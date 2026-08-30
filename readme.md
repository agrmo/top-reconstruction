Install

```
python -m ensurepip
python -m pip install pygments numpy pyyaml orion optuna uproot matplotlib pandas typing_extensions
```

Get material map
```
python3 Scripts/MaterialMapping/GeometryVisualisationAndMaterialHandling.py --geometry /home/user1/code/odd/source/config/odd-material-mapping-config.json
```

get new simulation using default parameters.
```
python -c "import get_simulation; get_simulation.get_new_simulation_from_default()"
```

get new simulation using parameters from the best trial in the given folder
```
python -c "import pathlib; import get_simulation; get_simulation.get_new_simulation_from_best_trial(pathlib.Path(''))"
```

get combined plots of teff, tdup, tfak, vs eta, phi, pt
```
python -c "import pathlib; import get_efficiency_pngs; get_efficiency_pngs.get_efficiency_pngs_combined([], [])"
```

e.g.

get grid given images
```
python -c "import get_png_grid; import pathlib; get_png_grid.get_png_grid_specific(pathlib.Path('/home/user1/time/2023-02-23/2023-02-23-11-14/single/'))"
```

Get score pngs given optimization
```
python -c "import get_score_pngs; import pathlib; get_score_pngs.get_score_pngs(pathlib.Path(...))"
```

Get pngs for given optimization
```
python -c "import get_pngs; get_pngs.get_pngs_optimization('/home/user1/time/2023-02-21/2023-02-21-23-06-52/')"
```

Get efficiency pngs given sequence
```
python -c "import get_efficiency_pngs; import pathlib; get_efficiency_pngs.get_efficiency_pngs(pathlib.Path('.../performance_ckf.root'))"
```

get optimization
```
python -c 'import optimize_optuna; optimize_optuna.optimize()'
```

get optimization results
```
python -c "import get_results; import pathlib; get_results.get_optimization_results(pathlib.Path(''))"
```
