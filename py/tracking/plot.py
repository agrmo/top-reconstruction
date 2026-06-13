from matplotlib import pyplot
import filetolist
import numpy

def plot_xyz(xstring, ystring, zstring, titlestring, xarray, yarray, zarray):
    # Plot an x-y-z graph.
    pass

def plot_xy(xstring, ystring, titlestring, xarray, yarray):
    # Plot an x-y graph.
    pass

def plot_array(xstring, ystring, titlestring, array):
    # Plot one array.
    
    pyplot.rcParams['font.family'] = 'Times New Roman'
    figure = pyplot.figure()
    figure.set_size_inches(4, 4)
    ax = figure.add_subplot()
    ax.set_ylabel(ystring)
    ax.set_xlabel(xstring)
    ax.set_title(titlestring)
    ax.set_color("black")
    ax.plot(array)
    pyplot.savefig(titlestring + '.png', bbox_inches = 'tight', dpi = 300)


#pyplot.rcParams['font.size'] = 18
#pyplot.rcParams['axes.linewidth'] = 2

# Generate 2 colors from the 'tab10' colormap
# colors = cm.get_cmap('tab10', 2)

# Add padding to axis labels
# ax.set_xlabel('Wavelength (nm)', labelpad=10)
# ax.set_ylabel('Absorbance (O.D.)', labelpad=10)

# Use latex in axis labels
# ax.set_xlabel(r'$\mathregular{\lambda}$ (nm)', labelpad=10)

# Set DPI
# savefig(..., dpi=100, ...)

def plot_grid():
    pyplot.rcParams['font.family'] = 'Times New Roman'
    
    sampled_array = numpy.loadtxt('dat/in/sampled_array').tolist()
    a_array = filetolist.filetolist('dat/in/a_array')
    p_array = filetolist.filetolist('dat/in/p_array')
    figure = pyplot.figure(figsize = (4, 6))
    grid = pyplot.GridSpec(3, 1)
    ax1 = figure.add_subplot(grid[0, 0])
    ax2 = figure.add_subplot(grid[1, 0])
    ax3 = figure.add_subplot(grid[2, 0])
    ax1.plot(sampled_array)
    ax2.plot(a_array)
    ax3.plot(p_array)
    ax1.set_title('Input IF')
    ax2.set_title('Output Amplitude')
    ax3.set_title('Output Phase')
    ax1.set_ylabel('Value (Volt)')
    ax2.set_ylabel('Amplitude (Volt)')
    ax3.set_xlabel('Measurement (n)')
    ax3.set_ylabel('Phase (rad)')
    
    pyplot.subplots_adjust(hspace = 0.75)
    
    for ax in figure.axes:
    	ax.get_lines()[0].set_color("black")
    
    pyplot.savefig('dat/out/ap.png', bbox_inches='tight', dpi=300)

