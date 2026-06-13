import pathlib
import get_efficiency_per_trial
import get_efficiency_pngs
import get_png_grid
import get_study
import get_time
import pathlib
import get_study
import get_efficiency_denominator

def get_trial_txt(trial, name, data_dirpath):
    with open(data_dirpath / name, 'w') as f:
        f.write(str(trial))
        
# Get all png files to analyze one optimization.
def get_optimization_results(data_dirpath):
    study = get_study.get_study(data_dirpath)
    best_trial = study.best_trial
    get_trial_txt(best_trial, 'best.txt', data_dirpath)
    best_trial_n = best_trial.number
    best_trial_dirpath = data_dirpath / ('trial_' + str(best_trial_n))
    get_efficiency_pngs.get_efficiency_pngs(best_trial_dirpath)
    get_study.get_score_png(data_dirpath)
    get_study.get_parameter_per_trial(data_dirpath)
    get_efficiency_per_trial.get_efficiency_per_trial(data_dirpath)
    get_time.get_time(data_dirpath)

def get_single_results_1p5to1p5(data_dirpath):
    get_efficiency_pngs.get_efficiency_pngs(data_dirpath)
    get_pngs_compare_1p5to1p5(data_dirpath)

def get_pngs_compare_3to3(data_dirpath):
    default_path_3to3 = pathlib.Path('/home/user1/time/2023-02-23/2023-02-23-11-14')
    get_efficiency_pngs.get_efficiency_pngs_combined([data_dirpath, default_path_3to3], ['Optimized', 'Default'], 0, 1)
    
def get_pngs_compare_1p5to1p5(data_dirpath):
    default_path_1p5to1p5 = pathlib.Path('/home/user1/time/2023-03-10/2023-03-10-07-07-07')
    get_efficiency_pngs.get_efficiency_pngs(data_dirpath)
    get_efficiency_pngs.get_efficiency_pngs_combined_ranged([data_dirpath, default_path_1p5to1p5], ['Optimized', 'Default'])
    get_efficiency_denominator.get_denominator_pngs_multiple([data_dirpath, default_path_1p5to1p5], ['Optimized', 'Default'])

def get_pngs_compare_1p5to3(data_dirpath):
    default_path_1p5to3 = pathlib.Path('/home/user1/time/2023-03-10/2023-03-10-07-22-01/')
    get_efficiency_pngs.get_efficiency_pngs_combined([data_dirpath, default_path_1p5to3], ['Optimized', 'Default'], 0, 0.02)
    get_efficiency_denominator.get_denominator_pngs_multiple([data_dirpath, default_path_1p5to3], ['Optimized', 'Default'])
    
def get_pngs_compare_3to3_1p5to1p5_combined():
    pass
