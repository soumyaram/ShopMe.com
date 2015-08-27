<!DOCTYPE html>
<html lang="en" ng-app="ShopMe">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ShopMe.com....</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body ng-controller="ShopMeCtrl" ng-init="loadProductOnBuy()">
<nav>
  <div class="container"> 
    
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="#">Brand</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a> </li>
        <li><a href="#">Link</a> </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a> </li>
            <li><a href="#">Another action</a> </li>
            <li><a href="#">Something else here</a> </li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a> </li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a> </li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right hidden-sm">
        <li><a href="#">Link</a> </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a> </li>
            <li><a href="#">Another action</a> </li>
            <li><a href="#">Something else here</a> </li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a> </li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>
<div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <div id="carousel1" class="carousel slide">
          <ol class="carousel-indicators">
            <li data-target="#carousel1" data-slide-to="0" class="active"> </li>
            <li data-target="#carousel1" data-slide-to="1" class=""> </li>
            <li data-target="#carousel1" data-slide-to="2" class=""> </li>
          </ol>
          <div class="carousel-inner">
            <div class="item"> <img class="img-responsive" src="img/1920x500.gif" alt="thumb">
              <div class="carousel-caption"> Carousel caption 1. Here goes slide description. Lorem ipsum dolor set amet. </div>
            </div>
            <div class="item active"> <img class="img-responsive" src="C:\images\images.jpg" alt="thumb">
              <div class="carousel-caption"> Welcome to Crazy Shopping </div>
            </div>
            <div class="item"> <img class="img-responsive" src="img/1920x500.gif" alt="thumb">
              <div class="carousel-caption"> Carousel caption 3. Here goes slide description. Lorem ipsum dolor set amet. </div>
            </div>
          </div>
          <a class="left carousel-control" href="#carousel1" data-slide="prev"><span class="icon-prev"></span></a> <a class="right carousel-control" href="#carousel1" data-slide="next"><span class="icon-next"></span></a></div>
      </div>
</div>
    <hr>
  </div>
<div class="container">
  <div class="row">
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
      <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-3 col-xs-2"><img class="img-circle" alt="Free Shipping" width="70px" height="60px"  src="images/shopme_logo.png"></div>
        <div class="col-lg-6 col-md-9 col-sm-9 col-xs-9">
          <h4>Free Shipping</h4>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
      <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-3 col-xs-2"><img class="img-circle" alt="Free Shipping" width="70px" height="60px" src="images/shopme_logo.png"></div>
        <div class="col-lg-6 col-md-9 col-sm-9 col-xs-9">
          <h4>Free Returns</h4>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
      <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-3 col-xs-2"><img class="img-circle" alt="Free Shipping" width="70px" height="60px" src="images/shopme_logo.png"></div>
        <div class="col-lg-6 col-md-9 col-sm-9 col-xs-9">
          <h4>Low Prices</h4>
        </div>
      </div>
    </div>
  </div>
</div>
<hr>
<h2 class="text-center">Enter your delivery details</h2>
<hr>
<div class="container" >
  <div class="row text-center" >
    <div class="col-sm-4 col-md-4 col-lg-4 col-xs-6" >
      <div class="thumbnail"> <img src="{{selectedProduct.imageUrl}}" alt="Thumbnail Image 1" class="img-responsive">
        <div class="caption">
          <h3>{{selectedProduct.name}}</h3>
          <p>{{selectedProduct.color}} - {{selectedProduct.name}} for {{selectedProduct.price}}</p>
        </div>
      </div>
    </div>
    <div class="col-sm-4 col-md-4 col-lg-4 col-xs-6" >
        <div>
        	<table>
        		<tr>
        			<td>
        				<label for="uName">Name </label>
        			</td>
        			<td>
        				<input type="text" id="uName" ng-model="orderDetails.name" />
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<label for="uEmail">Email </label>
        			</td>
        			<td>
        				<input type="text" id="uEmail" ng-model="orderDetails.email" />
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<label for="uQty">Quantity </label>
        			</td>
        			<td>
        				<input type="text" id="uQty" ng-model="orderDetails.qty" disabled="disabled" />
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<label for="uAddress">Address </label>
        			</td>
        			<td>
        				<input type="text" id="uAddress" ng-model="orderDetails.address" />
        			</td>
        		</tr>
        	</table>
          <p>{{selectedProduct.color}} - {{selectedProduct.name}} for {{selectedProduct.price}}</p>
        </div>
        <p><a href="#" class="btn btn-primary" role="button" ng-click="finalizeOrder()"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Buy </a></p>
      </div>
    </div>
    </div>
</div>

<hr>
<h2 class="text-center">&nbsp;</h2>
<hr>
<hr>
  <div class="container well">
    <div class="row">
      <div class="col-xs-6 col-sm-6 col-md-6 col-lg-7"> </div>
      <div class="col-xs-6 col-sm-6 col-md-6 col-lg-5">
        <address>
        <strong>ShopMe, Inc.</strong><br>
ISan Francisco,CA
        </address>
        <address>
        <strong>Full Name</strong><br>
        <a href="mailto:#">sme@shopme.com</a>
        </address>
        </div>
    </div>
  </div>

<footer class="text-center">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <p>Copyright © MyWebsite. All rights reserved.</p>
      </div>
    </div>
  </div>
</footer>
<script src="js/jquery-1.11.2.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/app.js"></script>
<script src="js/ShopMeController.js"></script>
</body>
</html>