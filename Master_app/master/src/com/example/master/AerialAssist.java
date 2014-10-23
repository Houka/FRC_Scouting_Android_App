package com.example.master;

public class AerialAssist {
	
	private String[] columnNames = {	"team_num",				//team number
										"match_num",			//match number
										"is_red",				//whether alliance is red
										"top_auto",				//top goals in auto
										"topMisses_auto",		//top goal misses in auto
										"topHot_auto",			//top hot goals in auto
										"bottom_auto",			//bottom goals in auto
										"botHot_auto",			//bottom hot goals in auto
										"defense",				//whether team defended
										"movement",				//whether team moved
										"cycle",				//total cycle num
										"Assist_throw",			//assist passes (array)
										"throw_fzone",			//passes from feeder zone
										"throw_tzone",			//from truss zone
										"throw_gzone",			//from goal zone
										"Assist_catch",			//assist catches (array)
										"catch_fzone",			//catches from feeder zone
										"catch_tzone",			//from truss zone
										"catch_gzone",			//from goal zone
										"truss_throw",			//all truss throws (array)
										"truss_miss",			//all missed truss throws (array)
										"truss_catch",			//truss catches (array)
										"top_tele",				//all top goals made
										"topMisses_tele",		//all top goal misses
										"bottom_tele",			//all bottom goals made
										"cycle_goals",			//which goal was made in each cycle (array)
																/***************************	
																 * 	-1 = missed
																 * 	 0 = nothing
																 * 	 1 = bottom goal
																 * 	 2 = top goal
																 ***************************/
										"cycle_time"			//duration of each cycle
									};
	
	private int row_id = 0;
	private int team_num=0, match_num=0,
			
				top_auto=0, topMisses_auto=0, topHot_auto=0, 
				bottom_auto=0, botHot_auto,
				
				cycle=0,
				
				throw_fzone=0,throw_tzone=0,throw_gzone=0,
				catch_fzone=0,catch_tzone=0,catch_gzone=0,
				
				top_tele=0,topMisses_tele=0,bottom_tele=0;
	
	private String assist_throw, assist_catch, truss_throw, truss_miss, truss_catch, cycle_goals, cycle_time;
	private int is_red=0,defense=0,movement=0;
	
	private int[] topMisses_tele_array;
	

	///////////////////////////////////////constructors///////////////////////////////////////////////
	
	public AerialAssist() {}
	public AerialAssist(int row_id, int team_num, int match_num, int is_red, int top_auto, 
					   int topMisses_auto, int topHot_auto, int bottom_auto, int botHot_auto, 
					   int defense, int movement, int cycle, String assist_throw,
					   int throw_fzone, int throw_tzone, int throw_gzone, String assist_catch,
					   int catch_fzone, int catch_tzone, int catch_gzone, String truss_throw, 
					   String truss_miss, String truss_catch, int top_tele, int topMisses_tele, 
					   int bottom_tele, String cycle_goals, String cycle_time) {
		//sets all data variables to global instances
		this.row_id 		= row_id;
		this.team_num 		= team_num;
		this.match_num 		= match_num;
		this.is_red 		= is_red;
		this.top_auto	 	= top_auto;
		this.topMisses_auto = topMisses_auto;
		this.topHot_auto 	= topHot_auto;
		this.bottom_auto 	= bottom_auto;
		this.botHot_auto 	= botHot_auto;
		this.defense 		= defense;
		this.movement 		= movement;
		this.cycle 			= cycle;
		this.assist_throw 	= assist_throw;
		this.throw_fzone 	= throw_fzone;
		this.throw_tzone 	= throw_tzone;
		this.throw_gzone 	= throw_gzone;
		this.assist_catch 	= assist_catch;
		this.catch_fzone 	= catch_fzone;
		this.catch_tzone 	= catch_tzone;
		this.catch_gzone 	= catch_gzone;
		this.truss_throw 	= truss_throw;
		this.truss_miss 	= truss_miss;
		this.truss_catch 	= truss_catch;
		this.top_tele 		= top_tele;
		this.topMisses_tele = topMisses_tele;
		this.bottom_tele 	= bottom_tele;
		this.cycle_goals 	= cycle_goals;
		this.cycle_time 	= cycle_time;
		
	}
	public AerialAssist(String input) {
		//converts a string of all data into appropriate 
		//data types and then assign to global variables in class
		
		//decoding string input and puts it in a String array
		String[] decodedData = new String[this.columnNames.length];
		int commaLocation = input.indexOf(",");
		int qouteLocation = input.indexOf("'");
		for (int i = 0; i < decodedData.length; i++){
			if (commaLocation < qouteLocation){
				decodedData[i] = input.substring(0, commaLocation);
				input = input.substring(commaLocation+1, input.length());
			}else{				
				input = input.substring(qouteLocation+1, input.length());
				qouteLocation = input.indexOf("'");
				decodedData[i] = input.substring(0, qouteLocation);
				
				if (qouteLocation+1==input.length()) break;
				else input = input.substring(qouteLocation+2, input.length());
			}

			commaLocation = input.indexOf(",");
			qouteLocation = input.indexOf("'");
		}
		
		//sets all data variables to global instances
		try{
			this.team_num 		= Integer.parseInt(decodedData[0]);
			this.match_num 		= Integer.parseInt(decodedData[1]);
			this.is_red 		= Integer.parseInt(decodedData[2]);
			this.top_auto	 	= Integer.parseInt(decodedData[3]);
			this.topMisses_auto = Integer.parseInt(decodedData[4]);
			this.topHot_auto 	= Integer.parseInt(decodedData[5]);
			this.bottom_auto 	= Integer.parseInt(decodedData[6]);
			this.botHot_auto 	= Integer.parseInt(decodedData[7]);
			this.defense 		= Integer.parseInt(decodedData[8]);
			this.movement 		= Integer.parseInt(decodedData[9]);
			this.cycle 			= Integer.parseInt(decodedData[10]);
			this.assist_throw 	= decodedData[11];
			this.throw_fzone 	= Integer.parseInt(decodedData[12]);
			this.throw_tzone 	= Integer.parseInt(decodedData[13]);
			this.throw_gzone 	= Integer.parseInt(decodedData[14]);
			this.assist_catch 	= decodedData[15];
			this.catch_fzone 	= Integer.parseInt(decodedData[16]);
			this.catch_tzone 	= Integer.parseInt(decodedData[17]);
			this.catch_gzone 	= Integer.parseInt(decodedData[18]);
			this.truss_throw 	= decodedData[19];
			this.truss_miss 	= decodedData[20];
			this.truss_catch 	= decodedData[21];
			this.top_tele 		= Integer.parseInt(decodedData[22]);
			this.topMisses_tele = Integer.parseInt(decodedData[23]);
			this.bottom_tele 	= Integer.parseInt(decodedData[24]);
			this.cycle_goals 	= decodedData[25];
			this.cycle_time 	= decodedData[26];
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	///////////////////////////////////////set methods//////////////////////////////////////////////
	public void setTeamNum(int i)		{this.team_num = i;}
	public void setMatchNum(int i)		{this.match_num = i;}
	public void setIsRed(int i)			{this.is_red = i;}
	public void setTopAuto(int i)		{this.top_auto = i;}
	public void setTopMissesAuto(int i)	{this.topMisses_auto = i;}
	public void setTopHotAuto(int i)	{this.topHot_auto = i;}
	public void setBottomAuto(int i)	{this.bottom_auto = i;}
	public void setBottomHotAuto(int i)	{this.botHot_auto = i;}
	public void setDefense(int i)		{this.defense = i;}
	public void setMovement(int i)		{this.movement = i;}
	public void setCycle(int i)			{this.cycle = i;}
	public void setAssistThrow(String i)	{this.assist_throw = i;}
	public void setThrowFZone(int i)	{this.throw_fzone = i;}
	public void setThrowTZone(int i)	{this.throw_tzone = i;}
	public void setThrowGZone(int i)	{this.throw_gzone = i;}
	public void setAssistCatch(String i)	{this.assist_catch = i;}
	public void setCatchFZone(int i)	{this.catch_fzone = i;}
	public void setCatchTZone(int i)	{this.catch_tzone = i;}
	public void setCatchGZone(int i)	{this.catch_gzone = i;}
	public void setTrussThrow(String i)	{this.truss_throw = i;}
	public void setTrussMiss(String i)	{this.truss_miss = i;}
	public void setTrussCatch(String i)	{this.truss_catch = i;}
	public void setTopTele(int i)		{this.top_tele = i;}
	public void setTopMissesTele(int i)	{this.topMisses_tele = i;}
	public void setBottomTele(int i)	{this.bottom_tele = i;}
	public void setCycleGoals(String i)	{this.cycle_goals = i;}
	public void setCycleTime(String i)	{this.cycle_time = i;}
	
	///////////////////////////////////////get methods//////////////////////////////////////////////
	public int getRowId()				{return row_id;}
	public int getTeamNum()				{return team_num;}
	public int getMatchNum()			{return match_num;}
	public int getIsRed()				{return is_red;}
	public int getTopAuto()				{return top_auto;}
	public int getTopMissesAuto()		{return topMisses_auto;}
	public int getTopHotAuto()			{return topHot_auto;}
	public int getBottomAuto()			{return bottom_auto;}
	public int getBottomHotAuto()		{return botHot_auto;}
	public int getDefense()				{return defense;}
	public int getMovement()			{return movement;}
	public int getCycle()				{return cycle;}
	public String getAssistThrow()		{return assist_throw;}
	public int getThrowFZone()			{return throw_fzone;}
	public int getThrowTZone()			{return throw_tzone;}
	public int getThrowGZone()			{return throw_gzone;}
	public String getAssistCatch()		{return assist_catch;}
	public int getCatchFZone()			{return catch_fzone;}
	public int getCatchTZone()			{return catch_tzone;}
	public int getCatchGZone()			{return catch_gzone;}
	public String getTrussThrow()		{return truss_throw;}
	public String getTrussMiss()		{return truss_miss;}
	public String getTrussCatch()		{return truss_catch;}
	public int getTopTele()				{return top_tele;}
	public int getTopMissesTele()		{return topMisses_tele;}
	public int getBottomTele()			{return bottom_tele;}
	public String getCycleGoals()		{return cycle_goals;}
	public String getCycleTime()		{return cycle_time;}
	
	//conversion of arrays to int[]
	public int[] getAssistThrowArray()		{return decodeString(assist_throw);}
	public int[] getAssistCatchArray()		{return decodeString(assist_catch);}
	public int[] getTrussThrowArray()		{return decodeString(truss_throw);}
	public int[] getTrussMissArray()		{return decodeString(truss_miss);}
	public int[] getTrussCatchArray()		{return decodeString(truss_catch);}
	public int[] getCycleTimeArray()		{return decodeString(cycle_time);}
	public int[] getCycleGoalsArray(){
		int[] tempArray = decodeString(cycle_goals);
		int[] result = new int[getCycle()];
		topMisses_tele_array = new int[getCycle()];
		
		int tempMissesCounter = 0;
		int tempCounter = 0;
		
		//splitting up the Cycle Goal Array into an array that only has misses and on that only has goals
		for (int i = 0; i<tempArray.length; i++){
			if(tempArray[i] < 0){
				//for the misses array
				tempMissesCounter --;
			}else{
				//for the goals array...int[] result <- what this method is returning
				result[tempCounter] = tempArray[i];
				topMisses_tele_array[tempCounter] = tempMissesCounter; 	//because if there is a hit there is no miss...thus we put in previous misses
				tempMissesCounter = 0; 							//resets num misses
				tempCounter++;
			}
		}
		
		return result;
	}
	public int[] getTopMissesTeleArray(){getCycleGoalsArray(); return topMisses_tele_array;}
	
	public int[] decodeString(String input){
		//finds num of comma in input
		int numComma = 0;
		String tempStr = input;
		while(tempStr.indexOf(",")>0){
			tempStr = tempStr.replaceFirst(",", "");
			numComma++;
		}
		
		if(numComma == 0){
			try{
				int[] a = {Integer.parseInt(input)};
				return a;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//decoding string input and puts it in a String array
		String[] decodedData = new String[numComma+1];
		int commaLocation = input.indexOf(",");
		for (int i = 0; i < decodedData.length; i++){
			if (input.indexOf(",") < 0){
				decodedData[i] = input;
				break;
			}
			
			decodedData[i] = input.substring(0, commaLocation);
			input = input.substring(commaLocation+1, input.length());

			if (input.indexOf(",") > 0)
				commaLocation = input.indexOf(",");
		}
		
		//change String[] decodeData to Integer array result
		int[] result = new int[numComma + 1];
		for (int i =0; i< decodedData.length; i++){
			try{
				result[i] = (Integer.parseInt(decodedData[i]));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String getTextData(){
		String record = ""+team_num+","+
						match_num+","+
						is_red+","+
						top_auto+","+
						topMisses_auto+","+
						topHot_auto+","+
						bottom_auto+","+
						botHot_auto+","+
						defense+","+
						movement+","+
						cycle+","+
						"'"+assist_throw+"',"+
						throw_fzone+","+
						throw_tzone+","+
						throw_gzone+","+
						"'"+assist_catch+"',"+
						catch_fzone+","+
						catch_tzone+","+
						catch_gzone+","+
						"'"+truss_throw+"',"+
						"'"+truss_miss+"',"+
						"'"+truss_catch+"',"+
						top_tele+","+
						topMisses_tele+","+
						bottom_tele+","+
						"'"+cycle_goals+"',"+
						"'"+cycle_time+"'";
		return record;
	}
	
	public String getXMLAutoRecord(){		
		String record = "<record>";
		record += "<TeamNumber>" 			+getTeamNum()+			"</TeamNumber>" +
				  "<MatchNumber>" 			+getMatchNum()+			"</MatchNumber>" +
				  "<Alliance-isRed>" 		+getIsRed()+			"</Alliance-isRed>" +
				  "<AutoTop>" 				+getTopAuto()+			"</AutoTop>" +
				  "<AutoTopMisses>" 		+getTopMissesAuto()+	"</AutoTopMisses>" +
				  "<AutoTopHot>" 			+getTopHotAuto()+		"</AutoTopHot>" +
				  "<AutoBottom>" 			+getBottomAuto()+		"</AutoBottom>" +
				  "<AutoBottomHot>" 		+getBottomHotAuto()+	"</AutoBottomHot>" +
				  "<Defended>" 				+getDefense()+			"</Defended>" +
				  "<Moved>"					+getMovement()+ 		"</Moved>";;
		record += "</record>";
		
		return record;
	}
	public String getXMLTeleRecord(){		
		String record = "";
		
		for (int i = 0; i < getCycle(); i++){
		record += "<record>";
		record +="<TeamNumber>" 			+getTeamNum()+						"</TeamNumber>" +
				  "<MatchNumber>" 			+getMatchNum()+						"</MatchNumber>" +
				  "<Alliance-isRed>" 		+getIsRed()+						"</Alliance-isRed>" +
				  "<TotalCycles>" 			+getCycle()+						"</TotalCycles>" +
				  "<PassesPerCycle>" 		+getAssistThrowArray()[i]+			"</PassesPerCycle>" +			//array
				  "<PassesFeederZone>" 		+getThrowFZone()+					"</PassesFeederZone>" +
				  "<PassesTrussZone>" 		+getThrowTZone()+					"</PassesTrussZone>" +
				  "<PassesGoalZone>" 		+getThrowGZone()+					"</PassesGoalZone>" +
				  "<CatchesPerCycle>" 		+getAssistCatchArray()[i]+			"</CatchesPerCycle>" +			//array
				  "<CatchesFeederZone>" 	+getCatchFZone()+					"</CatchesFeederZone>" +
				  "<CatchesTrussZone>" 		+getCatchTZone()+					"</CatchesTrussZone>" +
				  "<CatchesGoalZone>" 		+getCatchGZone()+					"</CatchesGoalZone>" +
				  "<TrussShots>" 			+getTrussThrowArray()[i]+			"</TrussShots>" +			//array
				  "<TrussMisses>" 			+getTrussMissArray()[i]+			"</TrussMisses>" +			//array
				  "<TrussCatches>" 			+getTrussCatchArray()[i]+			"</TrussCatches>" +			//array
				  "<TeleTop>" 				+getTopTele()+						"</TeleTop>" +
				  "<TeleTopMisses>" 		+getTopMissesTeleArray()[i]+		"</TeleTopMisses>" +
				  "<TeleBottom>" 			+getBottomTele()+					"</TeleBottom>" +
				  "<GoalPerCycle>" 			+getCycleGoalsArray()[i]+			"</GoalPerCycle>" +			//array
				  "<CycleTime-seconds>"		+getCycleTimeArray()[i]+ 			"</CycleTime-seconds>";		//array
		record += "</record>";
		}
		
		return  record;
	}

}
