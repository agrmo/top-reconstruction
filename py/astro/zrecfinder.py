from numpy import sqrt, infty
from scipy import integrate

########## Our data analaysis for the LCDM model #########
c = 299792.458
N_eff = 3.046
w_b = 0.02237
w_r = 2.469 * 10**(-5) * (1 + (7/8)*(4/11)**(4/3) * N_eff)
w_m = 0.1430
h0 = 0.6736

g1 = (0.0783 * w_b**(-0.238)) / (1 + 39.5 * w_b**(0.763))
g2 = 0.560 / (1 + 21.1 * w_b **(1.81))
z_rec = 1048 * (1 + 0.00124 * w_b**(-0.738)) * (1 + g1 * w_m**g2)

def r_zrec_finder(h):
    def r_zrec(z):
        c_s = c / sqrt(3 + (9/4) * (w_b/w_r) * (1 / (1+z)))
        return (c_s/100) / sqrt(w_m * (1+z)**3 + w_r * (1+z)**4 + (h**2 - w_m - w_r))
    result, error = integrate.quad(r_zrec, z_rec, infty)
    return result


def D_zrec_finder(h):
    def D_zrec(z):
        return (c/100) / sqrt(w_m * (1+z)**3 + w_r * (1+z)**4 + (h**2 - w_m - w_r))
    result, error = integrate.quad(D_zrec, 0, z_rec)
    return result


D_zrec1 = D_zrec_finder(h0)
r_zrec1 = r_zrec_finder(h0)


theta = r_zrec1 / D_zrec1


print("z_*: ", z_rec)
print("D_A(z_*): ", D_zrec1)
print("r_*:", r_zrec1)
print("theta_*:", round(theta, 8))
