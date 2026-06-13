# Authors: Agustin Romero, Justin Myles

from matplotlib import cm
from matplotlib.colors import ListedColormap, LinearSegmentedColormap
from matplotlib.widgets import Slider
import Ising
import argparse
import matplotlib.animation as animation
import matplotlib.pyplot as plt
import numpy as np
from cycler import cycler
import matplotlib

matplotlib.rcParams['axes.prop_cycle'] = cycler(color=['k'])

parser = argparse.ArgumentParser()
parser.add_argument('--size', dest='size', type=int)
parser.add_argument('--temp', dest='temp', type=float)
parser.add_argument('--field', dest='field', type=float)
parser.add_argument('--sweeps', dest='sweeps', type=int)
parser.add_argument('--periodic', dest='periodic', type=bool)
parseargs = parser.parse_args()

# Assignment defaults:
# T = 2.0 H = 0 J = 1 size = 100

fig, ax_list = plt.subplots(1, 3, figsize = (10, 4))
mycmap = ListedColormap(["yellow", "blue"])
plt.subplots_adjust(bottom = 0.3, top = 0.98, left = 0, right = 0.98)

# Make a horizontal slider to control the temperature
axT= plt.axes([0.1, 0.10, 0.26, 0.02])
T_slider = Slider(
    ax=axT,
    label='T field',
    valmin=1.0,
    valmax=5.0,
    valinit=parseargs.temp
)

# Make a horizontal slider to control the magnetic field
axT= plt.axes([0.1, 0.05, 0.26, 0.02])
h_slider = Slider(
    ax=axT,
    label='h field',
    valmin=-1.0,
    valmax=1.0,
    valinit=parseargs.field
)

h_avg_list = []
m_avg_list = []
model = Ising.Isingmodel(parseargs.size, parseargs.temp, parseargs.field)
im = ax_list[0].imshow(model.lattice.points, cmap = mycmap)

def updatefig(*args):
    H_avg, M_avg = model.sweep_n(parseargs.sweeps, T_slider.val, h_slider.val)

    h_avg_list.append(H_avg)
    m_avg_list.append(M_avg)

    im.set_array(model.lattice.points)
    
    grid_text = 'Sweeps = ' + f'{model.lattice.sweeps}'
    ax_list[0].set_xlabel(grid_text)

    h_text = 'H = ' + '{0:.4f}'.format(H_avg)
    ax_list[1].set_xlabel(h_text)
    ax_list[1].plot(h_avg_list)

    m_text = 'M = ' + '{0:.4f}'.format(M_avg)
    ax_list[2].set_xlabel(m_text)
    ax_list[2].plot(m_avg_list)

    #if (model.lattice.sweeps % 10 == 0):
    #    fig.savefig(f'{model.lattice.sweeps}.png', format = 'png')

ani = animation.FuncAnimation(fig, updatefig, interval = 20)
plt.show()
