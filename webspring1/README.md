
        http://localhost:8080/webspring1/ web tarayicidan girilir yani bu adrese request atilir.
        web.xml de ilk acilacak sayda welcome.htm olarak belirlenmistir.Bu durumda web.xml'den dolayi
        welcome.htm'ye request atilir. 
    
        Dispatcher servlet welcome.htm requestini alir ve konfigurasyon ayarlarina bakar.
        <prop key="/welcome.htm">welcomeController</prop> olarak tanimlandigindan id=welcomeController olan beani arar.
        <bean id="welcomeController" class="controller.welcomeController"/> controllar'i bulmak icin
        controller package altinda welcomeController Controller java class'ina requesti bildirir.

        welcomeController.java handleRequestInternal() methoduyla requesti yakalar. Reuqest'in icindeki
        bilgiye gore gosterecegi view dosyasini belirler. Ilk requestte bu deger null gelir ve default olarak
        welcome.jsp view'ini gostermek icin ModelAndView nesnesi olusturur.  Bu nesnenin icine 
        "message" key'i ile bir mesaj set edilir ve sayfa kullaniciya gonderilir. welcome.jsp sayfasinda
        ${message} keywordu ile ekrana mesaj gosterilir.
       
    
        welcome.jsp sayfasindan girilen text bilgisi form ile url'e eklenerek gonderilir. Ornek olarak
        http://localhost:8080/webspring1/?tf1=hello&b1=sayfaya+git url'i request olarak atiliyor. URL'i incelyecek
        olursak yine bir sayfa belirtilmemis durumda. Yani web.xml'de belirtilen <welcome-file>welcome.htm</welcome-file>
        request olarak olusturulacak.
        
        Bu durumda yukaridaki dispatcher servletin yaptigi url'e gore ilgili controller'a yonlendirme islemi yapilacak.
        welcomeController'a yonlendirilecek. welcomeController'da request icindeki tf1 degeri alincak yani URL'e bakarsak
        tf1=hello'dur. hello sayfasini view olarak belirlyecek ve icine mesaji yazip kullaniciya ModelAndView nesnesini donecek.
        Mesaj welcomeController icindeki mesaj ama sayfa hello.jsp olarak donecek.
    
        Eger URL http://localhost:8080/webspring1/welcome.htm?tf1=hello&b1=sayfaya+git seklinda girilip request web server'a
        gonderilmis olsaydi;
        dikkat edersek sayfa olarak welcome.htm'ye gitme istegi gonderilmis. Yani web.xml'de belirtilen <welcome-file>welcome.htm</welcome-file>
        request'i olusturulmayacak. Direk dispacher-servlet reuqestte bulunan welcome.htm sayfasi icin bir Controller arayacak.
        welcomeController'a yonlendirecek.  welcomeController'da request icindeki tf1 degeri alincak yani URL'e bakarsak
        tf1=hello'dur. hello sayfasini view olarak belirlyecek ve icine mesaji yazip kullaniciya ModelAndView nesnesini donecek.
        Mesaj welcomeController icindeki mesaj ama sayfa hello.jsp olarak donecek.
    
        Eger URL http://localhost:8080/webspring1/hello.htm seklinde request olarak gelseydi;
        URL'e bakilirsa sayfa istegi olarak hello.htm gelmistir. Yani web.xml'de belirtilen <welcome-file>welcome.htm</welcome-file>
        request'i olusturulmayacak. Dispatcher-Servlet  hello.htm  sayfasina gore bir Controller arayacak ve helloController'a request
        yonlendirilecek(handleRequestInternal() methoduna). helloController ise reuqest icinde tf1 degeri olmadigindan yani null oldugundan default olarak
        hello.jsp view'ini kullaniciya helloController icindeki mesaji set ederek gonderecek.
    
        Eger URL http://localhost:8080/webspring1/hello.htm?tf1=welcome&b1=sayfaya+git olarak gonderilirse yani hello.htm sayfasindaki
        form'a welcome yazilip sayfaya git butonuna basilirsa yukaridaki request olusur. Request'i incelersek;
        request istegi hello.htm'ye olusturulmus. Dispatcher-servlet bu requeste karsilik gelen controller sinifini bulup 
        requesti controller sinifinin handleRequestInternal() methoduna gonderecek. Request icindeki tf1=welcome oldugundan
        helloController welcome view'i icin ModelandView nesnesi olusturacak ve icerisine mesaj olarak helloController icindeki
        mesaj yazilacak. Bu response istegi yapana gonderilecek. Yani welcome.jsp sayfasi gonderilecek ama icine helloController'da
        olusturulmus mesaj set edilerek gonderilcek.
       
    
    
  
