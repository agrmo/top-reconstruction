import os
import pandas
import uproot
import sequence
import numpy
import json

class Objective:
    def __init__(self, output_path):
        self.output_path = output_path

    def __call__(self, trial):
        # Run the trial, return its score.
        param_dict = {
            'maxSeedsPerSpM': trial.suggest_int("maxSeedsPerSpM", 0, 5),
            'cotThetaMax': trial.suggest_float("cotThetaMax", 5.0, 10.0),
            'sigmaScattering': trial.suggest_float("sigmaScattering", 0.2, 50),
            'radLengthPerSeed': trial.suggest_float("radLengthPerSeed", 0.001, 0.1),
            'impactMax': trial.suggest_float("impactMax", 0.1, 25),
            'maxPtScattering': trial.suggest_float("maxPtScattering", 1, 50),
            'deltaRMin': trial.suggest_float("deltaRMin", 0.25, 30),
            'deltaRMax': trial.suggest_float("deltaRMax", 50, 300)
        }

        trial_path = self.output_path / ('trial_' + str(trial.number))
        trial_path.mkdir()
        root_path = trial_path / "performance_ckf.root"
        timing_path = trial_path / 'timing.tsv'
        
        sequence.run(trial_path, param_dict)
        
        root_dict = uproot.open(root_path)
        peff = root_dict["eff_particles"].member("fElements")[0]
        teff = root_dict['eff_tracks'].member('fElements')[0]
        tfak = root_dict["fakerate_tracks"].member("fElements")[0]
        tdup = root_dict["duplicaterate_tracks"].member("fElements")[0]
        score = peff + teff - tfak / 4 - tdup / 4

        return score
