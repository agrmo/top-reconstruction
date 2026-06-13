
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import cm
from matplotlib.colors import ListedColormap, LinearSegmentedColormap
import matplotlib.animation as animation
from matplotlib.widgets import Slider
import Ising

#  Thanks to Justin Myles

model = Ising.Isingmodel(100, 2.5, 0.0)
#  initializes an Ising model on a 100 x 100 square lattcie
#     at   T = 2.0  and   H = 0   (J = 1)

sweeps = 5

#   all of the stuff below is about the GUI:

fig, ax  = plt.subplots()
mycmap = ListedColormap(["yellow", "blue"])
im = plt.imshow(model.lattice.points, cmap = mycmap)

sweeps = 5

axcolor = 'lightgoldenrodyellow'
ax.margins(x=0)
plt.subplots_adjust(left=0.25, bottom=0.25)

# Make a horizontal slider to control the temperature
axT= plt.axes([0.32, 0.15, 0.52, 0.03], facecolor=axcolor)
T_slider = Slider(
    ax=axT,
    label='Temperature',
    valmin=1.0,
    valmax=5.0,
    valinit=2.26919
)

# Make a horizontal slider to control the magnetic field
axT= plt.axes([0.32, 0.05, 0.52, 0.03], facecolor=axcolor)
h_slider = Slider(
    ax=axT,
    label='h field',
    valmin=-1.0,
    valmax=1.0,
    valinit=0
)

def updatefig(*args):
    Hvalsum = 0.0
    Mvalsum = 0.0
    model.T = T_slider.val
    model.h = h_slider.val
    for count in range(sweeps):
        model.update_lattice()
        Hvalsum += model.Hval()
        Mvalsum += model.Mval()
              #  record the energy and the magnetization 
    fig.suptitle('Energy = '+('{0:.4f}'.format(Hvalsum/sweeps))+' Mag = '+ ('{0:.4f}'.format(Mvalsum/sweeps)))
    im.set_array(model.lattice.points)
    return im

#  finally, show the animation
ani = animation.FuncAnimation(fig, updatefig, interval = 20)
plt.show()

