import optuna

def objective(trial):
    x = trial.suggest_float('x', -10, 10)
    return (x - 2) ** 2

study = optuna.create_study()
study.optimize(objective, n_trials=100)

# study.add_trial( 
# study.add_trials(
# study.ask(       
# study.best_params
# study.best_trial
# study.best_trials    
# study.best_value     
# study.direction      
# study.directions         
# study.enqueue_trial(
# study.get_trials(      
# study.optimize(            
# study.pruner           
# study.sampler              
# study.set_system_attr(     
# study.set_user_attr(  
# study.stop()          
# study.study_name             
# study.system_attrs    
# study.tell(                                 
# study.trials
# study.trials_dataframe(
# study.user_attrs   

print(study.best_params)
