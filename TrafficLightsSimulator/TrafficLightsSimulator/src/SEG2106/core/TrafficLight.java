package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  enum Status { northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow, northAndSouthArrow, westAndEastGreen, southYellow, northGreenAndArrow, northYellow, southGreenAndArrow, westGreenAndArrow }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
	this.trafficLightManager = trafficLightManager;
	  
	setStatus(Status.northAndSouthGreen);
    
    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case northAndSouthGreen:
        setStatus(Status.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        setStatus(Status.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case northAndSouthYellow:
        setStatus(Status.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        setStatus(Status.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case northAndSouthGreen:
        // line 8 "model.ump"
        trafficLightManager.northGreen();
        // line 9 "model.ump"
        trafficLightManager.southGreen();
        // line 10 "model.ump"
        trafficLightManager.westRed();
        // line 11 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 16 "model.ump"
        trafficLightManager.northYellow();
        // line 17 "model.ump"
        trafficLightManager.southYellow();
        // line 18 "model.ump"
        trafficLightManager.westRed();
        // line 19 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 24 "model.ump"
        trafficLightManager.northRed();
        // line 25 "model.ump"
        trafficLightManager.southRed();
        // line 26 "model.ump"
        trafficLightManager.westGreen();
        // line 27 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 32 "model.ump"
        trafficLightManager.northRed();
        // line 33 "model.ump"
        trafficLightManager.southRed();
        // line 34 "model.ump"
        trafficLightManager.westYellow();
        // line 35 "model.ump"
        trafficLightManager.eastYellow();
        break;
	default:
		break;
    }
  }

  public void delete()
  {}

@Override
public boolean moderateTraffic() {
	switch(status)
    {
      case northGreenAndArrow:
        trafficLightManager.northGreenAndArrow();
        trafficLightManager.southRed();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case northYellow:
        trafficLightManager.northYellow();
        trafficLightManager.southRed();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case southGreenAndArrow:
        trafficLightManager.northRed();
        trafficLightManager.southGreenAndArrow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case southYellow:
        trafficLightManager.northRed();
        trafficLightManager.southYellow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westGreen();
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westYellow();
        trafficLightManager.eastYellow();
        break;
	default:
		break;
    }
	return false;
}

@Override
public boolean lowTraffic() {
    switch(status)
    {
      case northAndSouthArrow:
        trafficLightManager.northArrow();
        trafficLightManager.southArrow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case northAndSouthGreen:
        trafficLightManager.northGreen();
        trafficLightManager.southGreen();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        trafficLightManager.northYellow();
        trafficLightManager.southYellow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westGreen();
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        trafficLightManager.westYellow();
        trafficLightManager.eastYellow();
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        break;
	default:
		break;
}
	return false;
}

@Override
public boolean highTraffic() {
    switch(status)
    {
      case northGreenAndArrow:
        trafficLightManager.northGreenAndArrow();
        trafficLightManager.southRed();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case northYellow:
        trafficLightManager.northYellow();
        trafficLightManager.southRed();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case southGreenAndArrow:
        trafficLightManager.northRed();
        trafficLightManager.southGreenAndArrow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case southYellow:
        trafficLightManager.northRed();
        trafficLightManager.southYellow();
        trafficLightManager.westRed();
        trafficLightManager.eastRed();
        break;
      case westGreenAndArrow:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westGreenAndArrow();
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westGreen();
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        trafficLightManager.northRed();
        trafficLightManager.southRed();
        trafficLightManager.westYellow();
        trafficLightManager.eastYellow();
        break;
	default:
		break;
    }
	return false;
}

}