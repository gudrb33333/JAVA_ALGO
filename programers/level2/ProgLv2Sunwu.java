package level2;

public class ProgLv2Sunwu {

	static class Person{
		private String language;
		private String jopGroup;
		private String career;
		private String soulFood;
		private String score;
		
		Person(String language, String jopGroup, String career, String soulFood, String score){
			this.language = language;
			this.jopGroup = jopGroup;
			this.career = career;
			this.soulFood = soulFood;
			this.score = score;
		}
	}
	
	public static void main(String[] args) {
		
		String[] info =
				{
					"java backend junior pizza 150",
					"python frontend senior chicken 210",
					"python frontend senior chicken 150",
					"cpp backend senior pizza 260",
					"java backend junior chicken 80",
					"python backend senior chicken 50"
				};
		
		String[] query = 
				{
					"java and backend and junior and pizza 100",
					"python and frontend and senior and chicken 200",
					"cpp and - and senior and pizza 250",
					"- and backend and senior and - 150",
					"- and - and - and chicken 100",
					"- and - and - and - 150"
				};
		
	
	}

}
