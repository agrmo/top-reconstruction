
import numpy as np

# this module defines the classes Lattice and Isingmodel
# A Lattice is a 2D array with dimensions (size x size).
# The elements of the array are 1 or -1  (spin up or spin down)
# In all methods, p is a length-2 array giving the (integer) coordinates of an element.

# An Isingmodel is an Ising model on the lattice Lattice, with the ability to
#    compute its Energy = <H> and Magnetization = <S>
#   and to update itself with the Metropolis algorithm to reach thermal equilibrium

##  Thanks to Laura Peskin and Justin Myles

class Lattice:
    # This is the class constructor. It initializes an instance with 2 data
    # members which you can access as `self.size` and `self.points` from within class
    # methods, or as `L.size` and `L.points` from outside the class if you have an
    # instance called `L`.
    def __init__(self, size):
        self.size = size
        self.points = np.ones((self.size, self.size))
        self.points[1][1] = -1
        self.sweeps = 0

    def __repr__(self):
        return "<Lattice size: %s points: %s>" % (self.size, self.points)
        
    def value(self, p):
        # if p[1] == 0:
        #     return 1
        # elif p[1] == self.size - 1:
        #     return -1
        # else:
        return self.points[p[0]][p[1]]
    
    def flip(self, p):
        self.points[p[0]][p[1]] *= (-1)
    
    def right(self, p):
        return self.value([p[0], (p[1]-1)%self.size])
    
    def left(self, p):
        return self.value([p[0], (p[1]+1)%self.size])
    
    def upper(self, p):
        return self.value([(p[0]-1)%self.size, p[1]])
    
    def lower(self, p):
        return self.value([(p[0]+1)%self.size, p[1]])


    # ==================================

    
class Isingmodel:
    def __init__(self, size, T, h):
    # This is the class constructor. It initializes an instance with 4 data
    # members which you can access as `self.size`, `self.lattice`, `self.T` and `self.h`
    # from within class methods, or as `model.size`, `model.lattice`, etc. from outside
    # the class if you have an instance called `model`.
        self.size = size
        self.lattice = Lattice(size)
        self.T = T
        self.h = h
        
    def __repr__(self):
        return "<IsingModel lattice: %s>" % (self.lattice)
        
    # Evaluation of the Ising Model Hamiltonian for J = 1
    #   the method returns the energy per site
    def Hval(self):
        res = 0
        p = [0, 0]
        for i in range(self.lattice.size):
            p[0] = i 
            for j in range(self.lattice.size):
                p[1] = j
                val = self.lattice.value(p)
                res += (-1.0) * val * ( self.lattice.upper(p) +  self.lattice.right(p) + self.h )
        ressc = res/(self.size * self.size)
        return ressc

    # Value of the total magnetization.  The method returns the magnetization per site
    def Mval(self):
        res = 0
        p = [0, 0]
        for i in range(self.lattice.size):
            p[0] = i 
            for j in range(self.lattice.size):
                p[1] = j
                val = (1.0) * self.lattice.value(p)
                res += val 
        ressc = res/(self.size * self.size)
        return ressc

    # The difference between the value of the Hamiltonian at a point with and without a flipped spin
    #   J = 1 ,  h is the external magnetic field
    def Hdiff(self, p):
        return (2.0) * self.lattice.value(p) * (
            self.lattice.upper(p) 
            + self.lattice.lower(p) 
            + self.lattice.left(p) 
            + self.lattice.right(p)
            + self.h
        ) 
        
    # Metropolis algorithm for updating the spin at a point
    # T is the temperature, h is the magnetic field
    def update_point(self, p):
        diff = self.Hdiff(p)
        if (diff < 0):
            self.lattice.flip(p)
        elif (np.exp((-1.0)*diff/self.T) > np.random.random()):
            self.lattice.flip(p)
        
    # Sweep over the complete lattice and update each point
    def update_lattice(self):
        p = [0,0]
        for i in range(self.size):
            p[0] = i
            for j in range(self.size):
                p[1] = j
                self.update_point(p)
    
        self.lattice.sweeps += 1

    def sweep_n(self, n_sweeps, T, h):
        self.T = T
        self.h = h
        
        # Update the lattice parseargs.sweeps times and return the average H and M.
    
        Hvalsum = 0.0
        Mvalsum = 0.0
        for count in range(n_sweeps):
            self.update_lattice()
            Hvalsum += self.Hval()
            Mvalsum += self.Mval()

        H_avg = Hvalsum / n_sweeps
        M_avg = Mvalsum / n_sweeps

        # T h H M N
        print(self.T, ',', self.h, ',', H_avg, ',', M_avg, ',', self.lattice.sweeps)
            
        return H_avg, M_avg
