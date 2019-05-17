<!doctype html>
<html class="fixed">
	<head>

		<!-- Basic -->
		<meta charset="UTF-8">

		<title>@yield('title')</title>
		<link rel="icon" type="image/png" href="{{ asset('assets/img/ms-icon-70x70.png') }}">
		<meta name="keywords" content="HTML5 Admin Template" />
		<meta name="description" content="Porto Admin - Responsive HTML5 Template">
		<meta name="author" content="okler.net">

		<!-- Mobile Metas -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

		<!-- Web Fonts  -->
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css">

		<!-- Vendor CSS -->
		<link rel="stylesheet" href="{{ asset('assets/vendor/bootstrap/css/bootstrap.css') }}" />
		<link rel="stylesheet" href="{{ asset('assets/vendor/font-awesome/css/font-awesome.css') }}" />
		<link rel="stylesheet" href="{{ asset('assets/vendor/magnific-popup/magnific-popup.css') }}" />
		<!-- <link rel="stylesheet" href="{{ asset('assets/vendor/bootstrap-datepicker/css/datepicker3.css') }}" /> -->

		<!-- Specific Page Vendor CSS -->
		<link rel="stylesheet" href="{{ asset('assets/vendor/bootstrap-timepicker/css/bootstrap-timepicker.css') }}" />
		<link rel="stylesheet" href="{{ asset('assets/vendor/jquery-datatables-bs3/assets/css/datatables.css') }}" />
		<link rel="stylesheet" href="{{ asset('assets/vendor/owl-carousel/owl.carousel.css') }}" />
		<link rel="stylesheet" href="{{ asset('assets/vendor/owl-carousel/owl.theme.css') }}" />

		<!-- Theme CSS -->
		<link rel="stylesheet" href="{{ asset('assets/stylesheets/theme.css') }}" />

		<!-- Skin CSS -->
		<link rel="stylesheet" href="{{ asset('assets/stylesheets/skins/default.css') }}" />

		<!-- Theme Custom CSS -->
		<link rel="stylesheet" href="{{ asset('assets/stylesheets/theme-custom.css') }}">

		<!-- Head Libs -->
		<script src="{{ asset('assets/vendor/modernizr/modernizr.js') }}"></script>

		<style type="text/css">
		.navbar-right {
			padding-right: 40px;
		}
		.navbar-nav li a{
			color: white;
		}

		.navbar-nav li a:hover, .navbar-nav li a:active, .navbar-nav li a:focus{
			color: #34495e;
		}
		</style>

		@yield('css')

	</head>
	<body>
		@include('template.sidebar_left')
	</body>

	<!-- Vendor -->
	<script src="{{ asset('assets/vendor/jquery/jquery.js') }}"></script>
	<script src="{{ asset('assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js') }}"></script>
	<script src="{{ asset('assets/vendor/bootstrap/js/bootstrap.js') }}"></script>
	<script src="{{ asset('assets/vendor/nanoscroller/nanoscroller.js') }}"></script>
	<script src="{{ asset('assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js') }}"></script>
	<script src="{{ asset('assets/vendor/magnific-popup/magnific-popup.js') }}"></script>
	<script src="{{ asset('assets/vendor/jquery-placeholder/jquery.placeholder.js') }}"></script>
	
	<!-- Specific Page Vendor -->
	<!-- <script src="{{ asset('assets/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js') }}"></script> -->
	<script src="{{ asset('assets/vendor/jquery-datatables/media/js/jquery.dataTables.js') }}"></script>
	<script src="{{ asset('assets/vendor/jquery-datatables/extras/TableTools/js/dataTables.tableTools.min.js') }}"></script>
	<script src="{{ asset('assets/vendor/jquery-datatables-bs3/assets/js/datatables.js') }}"></script>
	<!-- <script src="{{ asset('assets/vendor/ios7-switch/ios7-switch.js') }}"></script> -->
	<script src="{{ asset('assets/vendor/jquery-validation/jquery.validate.js') }}"></script>
	<script src="{{  asset('assets/vendor/bootstrap-wizard/jquery.bootstrap.wizard.js') }}"></script>
	<script src="{{ asset('assets/vendor/pnotify/pnotify.custom.js') }}"></script>
	
	<script src="{{ asset('assets/vendor/owl-carousel/owl.carousel.js') }}"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="{{ asset('assets/javascripts/theme.js') }}"></script>
	
	<!-- Theme Custom -->
	<script src="{{ asset('assets/javascripts/theme.custom.js') }}"></script>
	
	<!-- Theme Initialization Files -->
	<script src="{{ asset('assets/javascripts/theme.init.js') }}"></script>

	<script src="{{ asset('assets/javascripts/tables/examples.datatables.tabletools.js') }}"></script>

	@yield('js')
</html>