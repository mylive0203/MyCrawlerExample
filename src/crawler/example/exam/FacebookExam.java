package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri =

				"https://graph.facebook.com/v2.7"
				+ "/crazyck101/posts?fields=id,message,reactions.type(ANGRY).limit(0).summary(total_count)&since=1480550400&until=1481328000"
				+ "&access_token=EAAaqFXTnmHEBAHTMBZAFARuPcdoatCvjVpn7dWzsZAKtTvasgNZAqL5iKtgiY5VwphBfYG8SzgboHRTrEVZAgbvN9LVqr7FZCoQQ1Lalxw2KEzEclUP646C036cVL9kfAyudhPt8618ZBMHlmKaAgya8RZAOOeY062rwu1mEN8IVgZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = data.select("reactions summary total_count").text();


			output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
