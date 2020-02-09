package com.zmf.zhihu;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by guoyu on 2015/11/5.
 */
@Table("zhihu_answer_info")
public class MS_answer_info {
    @Column
    private String answer_id;
    @Column
    private String username;
    @Column
    private String home_page;
    @Column
    private String tag;
    @Column
    private String text;
    @Column
    private String last_edit_time;
    @Column
    private String pub_time;
    @Column
    private int comment_num;
    @Column
    private int agree_num;
    @Column
    private String url;
    @Column
    private Date create_date;
    @Column
    private String keyword;
    @Column
    private String question_id;
    @Column
    private long request_id;
    
    /**
     * 是否认证
     */
    @Column
    private String certify;
    

	public String getCertify() {
		return certify;
	}

	public void setCertify(String certify) {
		this.certify = certify;
	}

	public long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHome_page() {
        return home_page;
    }

    public void setHome_page(String home_page) {
        this.home_page = home_page;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLast_edit_time() {
        return last_edit_time;
    }

    public void setLast_edit_time(String last_edit_time) {
        this.last_edit_time = last_edit_time;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getAgree_num() {
        return agree_num;
    }

    public void setAgree_num(int agree_num) {
        this.agree_num = agree_num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
