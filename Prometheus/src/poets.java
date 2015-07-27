import java.util.Arrays;

public class poets {

	public static String[] sortPoets (String a[]) {
		Arrays.sort(a);
		return a;
	}
		public static void main(String[] args) {
			String[] pisaki ={"Пушкин", "Лермонтов","Некрасов",
					"Толстой Л. Н.","Толстой А. Н.","Есенин","Паустовский"};
			for(int i=0;i<pisaki.length;i++){
			System.out.println(pisaki[i]+"  ");
			}
			System.out.println("\n");
			sortPoets(pisaki);
			for(int i=0;i<pisaki.length;i++){
			System.out.println(pisaki[i]+"  ");
			}
		}
	}