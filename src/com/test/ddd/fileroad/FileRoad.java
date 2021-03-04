package com.test.ddd.fileroad;

public class FileRoad {
	
	/*
	드라이브 위치와 상관없이 해당 파일이 프로젝트폴더(src\\com\\test\\ddd) 안에 존재한다면 사용 가능합니다.
	사용 방법 : 필요한 FileRoad.변수명
	ex > 업체 정보 더미 읽기 
		BufferedReader reader = new Bufferedreader(new FileReader(FileRoad.STOREINFO));
	*/
	
	public static final String CUSTOMERINFO = "src\\com\\test\\ddd\\dummy\\memberXY_customer.txt";//주문 회원 정보 더미
	public static final String STOREINFO = "src\\com\\test\\ddd\\dummy\\store.txt";//업체 회원 정보 더미
	public static final String RIDERINFO = "src\\com\\test\\ddd\\dummy\\riderFinal.txt";//라이더 회원 정보 더미
	public static final String STOREONERINFO = "src\\com\\test\\ddd\\dummy\\memberXY_store.txt";//라이더 회원 정보 더미
	public static final String MANAGERINFO = "src\\com\\test\\ddd\\dummy\\memberXY_manager.txt";//라이더 회원 정보 더미
	
	public static final String FAVORITEINFO = "src\\com\\test\\ddd\\dummy\\favoritelist.txt";//라이더 회원 정보 더미

	public static final String CUSTOMERFINAL = "src\\com\\test\\ddd\\dummy\\customerFinal.txt";
	public static final String STOREFINAL = "src\\com\\test\\ddd\\dummy\\storeFinal.txt";
	public static final String RIDERFINAL = "src\\com\\test\\ddd\\dummy\\riderFinal.txt";
	public static final String ORDERLIST = "src\\com\\test\\ddd\\dummy\\finishOrder.txt";
	public static final String BASKET = "src\\com\\test\\ddd\\dummy\\plusTotal.txt";
	
	public static final String TODAYORDERFINISH = "src\\com\\test\\ddd\\dummy\\todayOrderFinish.txt";
	public static final String TODAYBASKET = "src\\com\\test\\ddd\\dummy\\todayOrderbasket.txt";
	
	public static final String STOREMENU = "src\\com\\test\\ddd\\dummy\\menu.txt"; //업체 메뉴 더미
	
	public static final String REVIEW = "src\\com\\test\\ddd\\dummy\\Review.txt"; //리뷰 더미
	
	public static final String YEOKSAM = "src\\com\\test\\ddd\\dummy\\yeoksam.txt"; //역삼동 x,y 좌표
	
	public static final String FINISHORDER = "src\\com\\test\\ddd\\dummy\\finishOrder.txt"; //끝난 주문 더미
	public static final String TODAYORDER = "src\\com\\test\\ddd\\dummy\\finishOrder.txt"; //오늘 주문 더미
	
	public static final String BLACKLIST = "src\\com\\test\\ddd\\dummy\\BlackList.txt"; //블랙리스트
	
	public static final String MENU = "src\\com\\test\\ddd\\dummy\\menu.txt";
	
	public static final String QANDA = "src\\com\\test\\ddd\\dummy\\QandA.txt";//큐앤에이 더미
	public static final String NOTICE = "src\\com\\test\\ddd\\dummy\\notice.txt";//공지사항 더미
	public static final String REVIEWFINAL = "src\\com\\test\\ddd\\dummy\\Review.txt";//리뷰 더미
	public static final String BADWORDS = "src\\com\\test\\ddd\\dummy\\badWords.txt";// 비속어필터
	
	
	
	//준오
	
	public static final String TODAYORDERFINAL = "src\\com\\test\\ddd\\dummy\\todayOrderFinal.txt"; //금지어
	public static final String FAVORITEFOOD = "src\\com\\test\\ddd\\dummy\\favoritelist.txt"; //즐겨찾기 매장 더미(회원번호,업체번호,업체명)
	
	//푸른
	public static final String ORDERWITHREVIEW = "src\\com\\test\\ddd\\dummy\\todayOrderFinish_modify.txt"; //리뷰랑 finishOrder이랑 합쳐놓은것

	
}
