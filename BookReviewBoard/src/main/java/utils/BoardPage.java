package utils;

public class BoardPage {
    public static String pagingStr(int totalCount, int pageSize, int blockPage,
            int pageNum, String reqUrl, String searchField, String searchWord) {
        String pagingStr = "";

        // 단계 3 : 전체 페이지 수 계산
        int totalPages = (int) (Math.ceil(((double) totalCount / pageSize)));

        // 단계 4 : '이전 페이지 블록 바로가기' 출력
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
        if (pageTemp != 1) {
            
        	if(searchField != null) {
            	pagingStr += "<span id='bpage'><a href='" + reqUrl + "searchField=" + searchField + "&searchWord=" + searchWord + "&pageNum=1' > << </a></span>";
	            pagingStr += "&nbsp;";
	            pagingStr += "<span id='bpage'><a href='" + reqUrl + "searchField=" + searchField + "&searchWord=" + searchWord + "&pageNum=" + (pageTemp - 1)
	                         + "'> < </a></span>";
        		
            }else {
            	pagingStr += "<span id='bpage'><a href='" + reqUrl + "pageNum=1' > << </a></span>";
            	pagingStr += "&nbsp;";
            	pagingStr += "<span id='bpage'><a href='" + reqUrl + "pageNum=" + (pageTemp - 1)
            			+ "'> < </a></span>";
            }
        }

        // 단계 5 : 각 페이지 번호 출력
        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPages) {
            if (pageTemp == pageNum) {
                // 현재 페이지는 링크를 걸지 않음
                pagingStr += "&nbsp;<span id='cpage'>&nbsp;" + pageTemp + "&nbsp;</span>&nbsp;";
            } else {
                if(searchField != null) {
                	pagingStr += "&nbsp;<span id='page'><a href='" + reqUrl + "searchField=" + searchField + "&searchWord=" + searchWord + "&pageNum=" + pageTemp
                			+ "' >&nbsp;" + pageTemp + "&nbsp;</a></span>&nbsp;";
                	
                }else {
                	pagingStr += "&nbsp;<span id='page'><a href='" + reqUrl + "pageNum=" + pageTemp
                			+ "' >&nbsp;" + pageTemp + "&nbsp;</a></span>&nbsp;";
                }
            }
            
            pageTemp++;
            blockCount++;
        }

        // 단계 6 : '다음 페이지 블록 바로가기' 출력
        if (pageTemp <= totalPages) {
            if(searchField != null) {
	            pagingStr += "<span id='npage'><a href='" + reqUrl + "searchField=" + searchField + "&searchWord=" + searchWord + "&pageNum=" + pageTemp
	            		+ "'> > </a></span>";
	            pagingStr += "&nbsp;";
	            pagingStr += "<span id='npage'><a href='" + reqUrl + "searchField=" + searchField + "&searchWord=" + searchWord + "&pageNum=" + totalPages
	            		+ "'> >> </a></span>";
            	
	            
            }else {
               	pagingStr += "<span id='npage'><a href='" + reqUrl + "pageNum=" + pageTemp
            			+ "'> > </a></span>";
            	pagingStr += "&nbsp;";
            	pagingStr += "<span id='npage' class='next'><a href='" + reqUrl + "pageNum=" + totalPages
            			+ "'> >> </a></span>";
            
            }
        }
        return pagingStr;
    }
}
