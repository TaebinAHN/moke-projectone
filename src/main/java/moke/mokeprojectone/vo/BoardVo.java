package moke.mokeprojectone.vo;


import lombok.Data;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class BoardVo {

    private Integer boardNo;
    private String  boardInterest;
    private String  boardTitle;
    private String  boardContent;
    private String  boardName;
    private String  boardDate;
    private int     boardChk;
    private int     boardLike;
    private String  boardRegion;


    /* 페이지 시작 번호 */
    private int pageStart;

    /* 페이지 끝 번호 */
    private int pageEnd;

    /* 이전, 다음 버튼 존재 유무 */
    private boolean next, prev;

    /* 행 전체 개수 */
    private int total;

    /* 현재페이지 번호(pageNum), 행 표시 수(amount), 검색 키워드(keyword), 검색 종류(type)*/
    private BoardVo cri;

    private int pageNum;

    /* 페이지 표시 개수 */
    private int amount;

    /* 페이지 skip */
    private int skip;

    /* 검색 타입 */
    private String type;

    /* 검색 키워드 */
    private String keyword;

    /* Criteria 생성자 */
    public BoardVo(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum - 1) * amount;
    }

    /* Criteria 기본 생성자 */
    public BoardVo() {

        this(1, 10);
    }

    /* 검색 타입 데이터 배열 변환 */
    public String[] getTypeArr() {
        return type == null ? new String[]{} : type.split("");
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.skip = (pageNum - 1) * this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.skip = (this.pageNum - 1) * amount;
    }

    public String makeQueryString(int pageNum) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("searchType", type)
                .queryParam("keyword", keyword)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

    public BoardVo(BoardVo cri, int total) {

        /* cri, total 초기화 */
        this.cri = cri;
        this.total = total;

        /* 페이지 끝 번호 */
        this.pageEnd = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

        /* 페이지 시작 번호 */
        this.pageStart = this.pageEnd - 9;

        /* 전체 마지막 페이지 번호 */
        int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

        /* 페이지 끝 번호 유효성 체크 */
        if (realEnd < pageEnd) {
            this.pageEnd = realEnd;
        }

        /* 이전 버튼 값 초기화 */
        this.prev = this.pageStart > 1;

        /* 다음 버튼 값 초기화 */
        this.next = this.pageEnd < realEnd;
    }


}



