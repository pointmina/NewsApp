NewsApp - 뉴스앱(2) 탭별 기사목록 화면
-

요구사항
1. 홈 화면에서 탭을 선택할 때마다 보여지는 기사 목록 데이터가 변환 된다.
- https://github.com/material-components/material-components-android/blob/master/docs/components/Tabs.md
- 텝 레이아웃이라는 클래스를 활용하면 된다.
- 텝 레이아웃을 추가하고 탭을 추가할 때는 탭 아이템 항목을 개수만큼 추가하면 된다.
- 추가한 탭 아이템이 컨택되었는지 감지할 수 있도록 addOnTabSelectedListener라는 함수를 사용해라
- 어떤 탭이 선택됐는지 알림을 받을 수 있는 함수도 제공해주고 있다.
- 탭이 선택되었을 때 하단에 나타나는 화면은 어떤 클래스로 구현해야 할까
- 탭을 뷰페이저(ViewPager2 사용할거임 ㅇㅇ)랑 같이 활용을 하면 선택된 탭에 대한 페이지가 스와이프 되는 형태로 사용자에게 UI를 제공할 수 있다.
- 뱃지 형태(알림 몇개왔는지 뜨는거더 할 수 있따.)
- 어떤 카테고리든지 간에 하나의 프레그먼트를 재사용할 수 있는 형태로 UI를 구현?

2. 기사 데이터는 API와 연동을 해서 네트워크 통신 결과로서 전달된다.
- https://newsapi.org/ 사용
- https://developer.mozilla.org/en-US/docs/Web/HTTP
- get : 리소스를 요청을 할 때 전달하는 메서드 유형, 데이터를 받아보고 싶은게 있으면 get으로 해당 url 주소로 요청을 한다.
- post : 특정 리소스를 제출을 할 때, 사용하는 메소드의 종류
- put : 똑같이 리소스를 전달을 하는데, 기존에 제출했던 리소스를 수정하게 되면 post대신 put 메서드로 요청
- delete : 특정 리소스 삭제
- https://developer.android.com/develop/connectivity/network-ops/connecting?hl=ko
- 
  
4. 리사이클러 뷰 설정
