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

2-1. Retrofit
- https://square.github.io/retrofit/
- https://square.github.io/okhttp/
- okhttp 로그에서 상세한 내용 확인 가능
- 코틀린 코루틴으로 네트워크 통신을 요청할 때는 return 타입을 받아보고 싶은 타입으로 하고 이 함수를 suspender 함수로 선언을 해야지만 retrofit과 결합을 해서 코루틴으로 비동기적인 요청을 수행할 수 있따.
- api키 노출: authoriztion or x-api key
- local.properties


2-2. glide
- 이미지 로딩
- https://github.com/bumptech/glide

삽질. 
- 어댑터 객체를 미리 만들고 추후에 어댑터 객체를 생성하고 리사이클 어댑터를 초기화 할거냐?!
- 아니면 데이터가 도착해야만 어댑터를 생성하게 할거냐?!
1. 화면 전환 중에 런타임 앱이 종료됨 -> error : NullPointerException
리사이클러뷰의 어댑터를 초기화하려고 했는데 변수에 접근을 하니깐 이미 디스트로이된 부분에 널값이 할당되었는데 다시 어댑터를 초기화하고 접근을 하려고 하니깐 에러가 발생해쑴
=> 어댑터가 생성될때 생성자 파라미터로 전달되는 값을보면, 네트워크 통신의 결과로 가져오는 데이터이고, 바인딩 변수는 널로 초기화 되어 있고 메모리에서 해제가 된 시점인데 그 이후에 네트워크 통신의 응답 결과가 도착이 되었고 어댑터 객체를 만들어서 초기화하려다 보니깐 오류가 났다.

2. 리사이클러 뷰의 목록형 ui가 업데이트 안됨
어댑터에 새로운 값을 전달했는데 업데이트가 안된다.
=> notifyDataSetChanged()





4. 리사이클러 뷰 설정
