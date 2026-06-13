import ROOT
import get_efficiency_keys
import pathlib

def get_legend(labels, thisograms):
    x1 = 0.8;
    y1 = 0.8;
    width = 0.15;
    height = 0.15;
    x2 = x1 + width;
    y2 = y1 + width;        
    legend = ROOT.TLegend(x1, y1, x2, y2)

    for i, thistogram in enumerate(thisograms):
        legend.AddEntry(thistogram, labels[i], 'f')

    return legend

def get_denominator_pngs_single(path):
    tfile = ROOT.TFile.Open(path)
    efficiency_keys = get_efficiency_keys.get_efficiency_keys()

    for key in efficiency_keys:
        tefficiency = tfile.Get(key)
        totalhistogram = tefficiency.GetTotalHistogram()
        tcanvas = ROOT.TCanvas()
        tcanvas.SetCanvasSize(2000, 500)
        totalhistogram.Draw()
        ROOT.gPad.SetLogy()
        tcanvas.Print(key + '.png')

# Given the list of paths, get the efficiency histograms and overlay
# them.  Also, plot the filenames
def get_denominator_pngs_multiple(paths, labels):
    efficiency_keys = get_efficiency_keys.get_efficiency_keys()
    
    outpath = paths[0] / 'denom'
    if not outpath.exists():
        outpath.mkdir()
    
    tfiles = []
    for p in paths:
        tfiles.append(ROOT.TFile.Open(str(p / 'performance_ckf.root')))

    for key in efficiency_keys:
        tcanvas = ROOT.TCanvas()
        tcanvas.SetCanvasSize(1000, 400)
        ROOT.gPad.SetLogy()
        totalhistograms = []
        
        for i, t in enumerate(tfiles):
            tefficiency = t.Get(key)
            totalhistogram = tefficiency.GetTotalHistogram()
            # Set the title, because its more descriptive.
            totalhistogram.SetTitle('Distribution')
            # Set to false, because it doesnt stack.
            totalhistogram.SetStats(False)
            totalhistogram.SetLineColor(i + 1)
            totalhistograms.append(totalhistogram)
            
            if i == 0:
                totalhistogram.Draw()
            else:
                totalhistogram.Draw('same')
                
        legend = get_legend(labels, totalhistograms)
        legend.Draw()
        tcanvas.Print(str(outpath / (key + '_denom.png')))
