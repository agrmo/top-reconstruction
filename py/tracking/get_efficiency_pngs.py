import ROOT
import pathlib
import get_efficiency_keys

def get_efficiency_titles():
    return ['Track Efficiency', 'Track Efficiency', 'Track Efficiency', 'Track Fake Rate', 'Track Fake Rate', 'Track Fake Rate', 'Track Duplicate Rate', 'Track Duplicate Rate', 'Track Duplicate Rate']

def get_efficiency_png(tefficiency, title, filename, dirpath):
    tcanvas = ROOT.TCanvas()
    tefficiency.Draw()
    tefficiency.SetTitle(title)
    tcanvas.Print(str(dirpath / (filename + '.png')))

def get_efficiency_pngs(dirpath):
    efficiency_keys = get_efficiency_keys.get_efficiency_keys()
    efficiency_titles = get_efficiency_titles()
    tfile = ROOT.TFile.Open(str(dirpath / 'performance_ckf.root'))

    outpath = dirpath / 'single'
    if not outpath.exists():
        outpath.mkdir()
    
    for i, key in enumerate(efficiency_keys):
        tefficiency = tfile.Get(key)
        title = efficiency_titles[i]
        get_efficiency_png(tefficiency, title, key, outpath)

# Get the legend for these histograms with these labels. For some
# reason, the legend has to be drawn in the same code scope as the
# tcanvas. So return the tlegend and then have the caller draw it. Do
# not mess with the color of the tefficiency, assume it is already
# set.
def get_legend(labels, thisograms):
    x1 = 0.85;
    y1 = 0.85;
    width = 0.1;
    height = 0.1;
    x2 = x1 + width;
    y2 = y1 + width;        
    legend = ROOT.TLegend(x1, y1, x2, y2)

    for i, thistogram in enumerate(thisograms):
        legend.AddEntry(thistogram, labels[i], 'f')

    return legend

def get_efficiency_pngs_combined_ranged(dirpaths, labels):
    get_efficiency_pngs_combined(dirpaths, labels, 0, 1)
    get_efficiency_pngs_combined(dirpaths, labels, 0.9, 1)
    get_efficiency_pngs_combined(dirpaths, labels, 0, 0.1)
    
# Make all efficiency plots from the root files, combining the ones of
# the same type.
def get_efficiency_pngs_combined(dirpaths, labels, min, max):
    rootpaths = [d / 'performance_ckf.root' for d in dirpaths]
    tfiles = [ROOT.TFile.Open(str(r)) for r in rootpaths]
    efficiency_keys = get_efficiency_keys.get_efficiency_keys()
    efficiency_titles = get_efficiency_titles()

    outpath = dirpaths[0] / ('compare-' + str(min) + '-' + str(max))
    if not outpath.exists():
        outpath.mkdir()
        
    for i, key in enumerate(efficiency_keys):
        tcanvas = ROOT.TCanvas()
        tefficiencies = []
        for t in tfiles:
            tefficiencies.append(t.Get(key))

        for j, tefficiency in enumerate(tefficiencies):
            tefficiency.SetLineColor(j + 1)
            if (j == 0):
                tefficiency.Draw()
            else:
                tefficiency.Draw('same')

            tefficiency.SetTitle(efficiency_titles[i])
            ROOT.gPad.Update()
            graph = tefficiency.GetPaintedGraph()
            graph.SetMinimum(min)
            graph.SetMaximum(max)

        legend = get_legend(labels, tefficiencies)
        legend.Draw()
        tcanvas.Print(str(outpath / (key + '.png')))

