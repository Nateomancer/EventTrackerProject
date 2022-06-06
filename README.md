# EventTrackerProject

This is the start of a progress tracker for a common powerlifting routine called 531. As a former competitive powerlifter, I trained alongside a powerlifting coach that would create training plans for me, this was a great advantage as i didn't have to worry about what I had to do to train. Through this, I learned about creating powerlifting routines.  Before this, I followed various gym routines posted online for free, some were good, others were not.  My goal with this is to give access to others who don't have the access to a trainer.

There are a variety of training methods, but one of the most common is the conjugate method, and the 531 training method. Both follow t a similar philosophy but have differences in the execution.,  In 531, your training routine is based on the max amount of weight you can bench, squat, and deadlift.  Based on those, the weight for training cycle is calculated based on percentage.  If your max bench is 315, then your training day for bench press 185 Ibs, for the first 5 sets, each 5-8 reps. After completing the 5 sets, you do 531.  You lift 235 5 times, then you lift 270 for 3 reps, and for your finally lift you lift 270 for one rep.  You then finish by putting your starting weight back on the bar, in this case 185, and you perform a AMRAP (As many reps as possible) set. Then you move on to either  secondary lift that complements the bench press, like shoulder or incline press, and then accessory exercises, which are additional exercise that you can implement in your routine. Both the secondary training lift and accessories are optional, however they are encouraged, especially the accessories.  The goal with accessories is target your "weak points", such as isolation work with exercise machines, dumbbells, body weight exercise (push ups) etc.

I created a database which currently has 5 tables, user, training_day_lift, training_day_log, warmup, and accessory_work.  As of now only the training_day_lift is implemented, which is the training day plan for the user.  They will follow the routine listed in the plan, this table shows contains one of the three powerlifting lifts (bench press, squat, and deadlift), and the amount of weight for each set.  The user will then be able to log the lifts in the training day log, were they able to complete the workout, how difficult was it, did the weight feel heavy etc.  They can also log any warmups or accessory work in their respective tables.  The user will frist have to create an account and enter their max bench, squat, and deadlift, which will then be used to calculate each training day.  The percent can very, but its typically 70%-90% for each each, moving up by 5-10% for each set.  If the user was able to complete the 531 workout, the following week will have a slight increase to the weight of each lift, if not the weight will either stay the same, or decrease. After a period of couple weeks a deload week (easy week) will be suggested.

## Technology

Java
Spring Boot
Spring Data
JPA
REST Api

### REST API Reference
| Return Type   | Route                 | Functionality                  |
|---------------|-----------------------|--------------------------------|
| `List<TrainingDayLift>`  |`GET trainingDayLifts`        | Gets all trainingDayLifts                 |
| `TrainingDayLift`        |`GET trainingDayLifts/{id}`   | Get one trainingDayLift by id             |
| `TrainingDayLift`        |`POST trainingDayLifts/{id}`   | Create one TrainingDayLift            |
| `TrainingDayLift`        |`PATCH trainingDayLifts/{id}`   | Update one TrainingDayLift            |
| `TrainingDayLift`        |`DELETE trainingDayLifts/{id}`   | Delete one TrainingDayLift             |
