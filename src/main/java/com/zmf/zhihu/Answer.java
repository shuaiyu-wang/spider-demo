package com.zmf.zhihu;

import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;

public class Answer {
	public static void main(String[] args) {
		String questionId = "37443576";
		String url = "";
		int offset = 0;
		for (int i = 0; i < 10; i++) {
			url = "https://www.zhihu.com/api/v4/questions/" + questionId
					+ "/answers?include=data%5B%2A%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cis_labeled%2Cis_recognized%2Cpaid_info%2Cpaid_info_content%3Bdata%5B%2A%5D.mark_infos%5B%2A%5D.url%3Bdata%5B%2A%5D.author.follower_count%2Cbadge%5B%2A%5D.topics&limit=5&offset="
					+ offset + "&platform=desktop&sort_by=default";
			String json = "";
			try {
				// 插库
				System.out.println(url);
				json = HttpBase.get(url, "utf-8").getResult();
				JSONObject obj = JSONObject.parseObject(json);
				Boolean bool = obj.getJSONObject("paging").getBoolean("is_end");
				System.out.println(bool);
				if (bool) {
					break;
				}
				offset = offset + 5;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
