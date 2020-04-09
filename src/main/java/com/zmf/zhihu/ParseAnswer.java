package com.zmf.zhihu;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;

public class ParseAnswer {

	public static void main(String[] args) {
		String url = "https://www.zhihu.com/api/v4/questions/37574068/answers?include=data%5B%2A%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cis_labeled%2Cis_recognized%2Cpaid_info%2Cpaid_info_content%3Bdata%5B%2A%5D.mark_infos%5B%2A%5D.url%3Bdata%5B%2A%5D.author.follower_count%2Cbadge%5B%2A%5D.topics&limit=5&offset=0&platform=desktop&sort_by=default";
		String json = "";
		try {
			json = HttpBase.get(url, "utf-8").getResult();
			JSONObject obj = JSONObject.parseObject(json);
			JSONArray data = obj.getJSONArray("data");
			for (int i = 0; i < data.size(); i++) {
				JSONObject answer = data.getJSONObject(i);
				String type = answer.getString("type");
				if (!"answer".equals(type)) {
					continue;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String answerId = answer.getString("id");
				String questionId = answer.getJSONObject("question").getString("id");
				String name = answer.getJSONObject("author").getString("name");
				String tag = answer.getJSONObject("author").getString("headline");
				String answerUrl = answer.getString("url");
				String createTime = sdf.format(new Date(Long.valueOf(answer.getString("created_time") + "000")));
				String updateTime = sdf.format(new Date(Long.valueOf(answer.getString("updated_time") + "000")));
				String voteupCount = answer.getString("voteup_count");
				String commentCount = answer.getString("comment_count");
				String content = answer.getString("content").replaceAll("\\&[a-zA-Z]{1,10};", "")
						.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
				String excerpt = answer.getString("excerpt").replaceAll("\\&[a-zA-Z]{1,10};", "")
						.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
				MS_answer_info ainfo = new MS_answer_info();
				ainfo.setAnswer_id(answerId);
//				ainfo.setUsername(username);
//				ainfo.setHome_page(home_page);
//				ainfo.setTag(tag);
				ainfo.setText(content);
				ainfo.setLast_edit_time(updateTime);
				ainfo.setPub_time(createTime);
				ainfo.setComment_num(Integer.parseInt(commentCount));
				ainfo.setAgree_num(Integer.parseInt(voteupCount));
				ainfo.setUrl(answerUrl);
				ainfo.setCreate_date(new Date());
//				ainfo.setKeyword(task.getKeyword());
				ainfo.setQuestion_id(questionId);
//				ainfo.setRequest_id(task.getId());
				ainfo.setCertify("");
				try {
//					biDao.fastInsert(ainfo);
				} catch (Exception e) {
					e.printStackTrace();
//					logger.error("===============" + "知乎问题回答信息入BI库失败" + "===============", e);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
