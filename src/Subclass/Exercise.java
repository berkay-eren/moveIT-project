package Subclass;

public class Exercise {

	private String exerciseType;
	private int durationInMinutes;
	private static final int YOGA_CALORIES_PER_MIN = 6;  
	private static final int LIFTING_CALORIES_PER_MIN = 10;
	private static final int RUNNING_CALORIES_PER_MIN = 12;
	
	public Exercise(String exercise, int duration) {
		super();
		this.exerciseType = exercise;
		this.durationInMinutes = duration;
	}

	public String getExerciseType() {
		return exerciseType;
	}
	
	public void setExerciseType(String exercise) {
		this.exerciseType = exercise;
	}
	
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	public double calculateCaloriesBurned() {
		
		double caloriesPerMinute = 0;
		
		switch (exerciseType.toLowerCase()) {
        	case "yoga":
        		caloriesPerMinute = YOGA_CALORIES_PER_MIN;
        		break;
        	case "lifting":
            	caloriesPerMinute = LIFTING_CALORIES_PER_MIN;
            	break;
        	case "running":
        		caloriesPerMinute = RUNNING_CALORIES_PER_MIN;
        		break;
        	default:
        		return 0.0;
		}
		
		return caloriesPerMinute*durationInMinutes;
	}

	@Override
	public String toString() {
		return " ExerciseType= " + exerciseType + ", durationInMinutes= " + durationInMinutes + "\n";
	}
	
}
