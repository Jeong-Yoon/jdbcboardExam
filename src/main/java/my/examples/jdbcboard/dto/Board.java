package my.examples.jdbcboard.dto;

import java.util.Date;

public class Board {
    private long id;
    private Long userId;
    private String userName;
    private String title;
    private String content;
    private int prNo;
    private int reDepth;
    private int reOrd;
    private Date regdate;
    private int readCnt;

    public Board(){
        this.regdate = new Date();
        this.readCnt = 0;
    }

    public Board(String title, String content, String name) {
        this();
        this.title = title;
        this.content = content;
        this.userName = name;
    }

    public Board(String title, String content, Long userId) {
        this();
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Board(Long id, String title, String content, String name, Date regdate, int readCnt) {
        this(title, content, name);
        this.id = id;
        this.regdate = regdate;
        this.readCnt = readCnt;
    }

    public Board(long id, Long userId, String userName, String title, int prNo, int reDepth, int reOrd, Date regdate, int readCnt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.prNo = prNo;
        this.reDepth = reDepth;
        this.reOrd = reOrd;
        this.regdate = regdate;
        this.readCnt = readCnt;
    }
    public Board(long id, Long userId, String userName, String title, String content, int prNo, int reDepth, int reOrd, Date regdate, int readCnt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.prNo = prNo;
        this.reDepth = reDepth;
        this.reOrd = reOrd;
        this.regdate = regdate;
        this.readCnt = readCnt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrNo() {
        return prNo;
    }

    public void setPrNo(int prNo) {
        this.prNo = prNo;
    }

    public int getReDepth() {
        return reDepth;
    }

    public void setReDepth(int reDepth) {
        this.reDepth = reDepth;
    }

    public int getReOrd() {
        return reOrd;
    }

    public void setReOrd(int reOrd) {
        this.reOrd = reOrd;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(int readCnt) {
        this.readCnt = readCnt;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", prNo=" + prNo +
                ", reDepth=" + reDepth +
                ", reOrd=" + reOrd +
                ", regdate=" + regdate +
                ", readCnt=" + readCnt +
                '}';
    }
}
