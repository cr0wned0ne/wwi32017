var name = "Tom";

var sayHi = function(lastname) {
	var myHi = "Hi";
	var name = "Peter";
	var fullname = name + lastname;
	this.greeting = myHi + fullname;
}

alert(this.greeting);









var lawuf = new Object();

lawuf.load = function() {
  console.log("logged in: " + lawuf.loggedIn)
  if (!lawuf.loggedIn) {
    lawuf.hideContent();
  }


  $('#loginButton').click(function() {
    lawuf.login();
  });

  var rawButton = document.getElementById('rawButton');
  rawButton.addEventListener('click', function() {
    console.log('raaaaw');
  });

  rawButton.addEventListener('click', function() {
    lawuf.next();
  })

  var nopeButton = document.getElementById('nopeButton');
  nopeButton.addEventListener('click', function() {
    console.log('nope!');
  });
  nopeButton.addEventListener('click', function() {
    lawuf.next();
  })
}


lawuf.login = function() {
  lawuf.username = document.getElementById('username').value;
  lawuf.password = document.getElementById('password').value;
  if (lawuf.username && lawuf.password) {
	
     $.post('/lawuf-server/login',{
    	 	username : lawuf.username,
    	 	password : lawuf.password
     }, function(data) {
    	 	lawuf.loggedIn = true;
    	    lawuf.hideLogin();
    	    lawuf.showContent();
     }).fail(function() {
 		alert("Wrong username or password!");
 	}); 
  }
}

lawuf.logout = function() {
  lawuf.hideContent();
  lawuf.loggedIn = false;
  lawuf.username = undefined;
  lawuf.password = undefined;
  lawuf.showLogin();
}

lawuf.hideLogin = function() {
  if(lawuf.loggedIn) {
    var headerControls = document.getElementsByClassName('login');
    for (var i = 0; i < headerControls.length; i++) {
      ctrl = headerControls[i];
      ctrl.style.display = 'none';
    }
    this.showContent();
  }
}

lawuf.showLogin = function() {
  if(!lawuf.loggedIn) {
    var headerControls = document.getElementsByClassName('login');
    for (var i = 0; i < headerControls.length; i++) {
      ctrl = headerControls[i];
      ctrl.style.display = 'block';
    }
  }
}

lawuf.hideContent = function() {
  var content = document.getElementById('content');
  content.style.display = 'none';

  var button = document.getElementById('logoutButton');
  button.style.display = 'none';

  var landing = document.getElementById('landing');
  landing.style.display = "block";

}

lawuf.showContent = function() {
  var content = document.getElementById('content');
  content.style.display = 'block';

  var content = document.getElementById('logoutButton');
  content.style.display = 'block';

  var landing = document.getElementById('landing');
  landing.style.display = "none";
}

lawuf.next = function() {
  var profileImg = document.getElementById('profileImg');
  var src = profileImg.src;
  var path = src.substring(0, src.lastIndexOf("/") + 1);
  var file = src.substring( src.lastIndexOf("/") + 1, src.length);
  var number = file.substring(0, file.lastIndexOf("."));
  if (number < 5) {
    number++;
  } else {
    number = 0;
  }
  var newPath = path + number + ".jpg";
  profileImg.src = newPath;
}


lawuf.getLocation = function() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(lawuf.showPosition);
  } else {
    geoDemo.innerHTML = "Geolocation is not supported by this browser.";
  }
}

lawuf.showPosition = function(position) {
  document.getElementById('geoDemo').innerHTML = "Latitude: " + position.coords.latitude +
  "<br>Longitude: " + position.coords.longitude;
}

lawuf.load();
