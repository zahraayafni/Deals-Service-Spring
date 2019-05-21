<?php 
    $token = $_GET['token'];
	$r_id = $_GET['r_id'];
	if ($_SERVER["REQUEST_METHOD"] == "POST") {
		//API Url
		$url = 'https://deals-service-spring.herokuapp.com/deals/'.$r_id;
		 
		//Initiate cURL.
		$ch = curl_init($url);
		 
		//The JSON data.
		$jsonData = array(
		    'code' 				=> $_POST["code"],
		    'name' 				=> $_POST["name"],
		    'description' 		=> $_POST["description"],
		    'type' 				=> $_POST["type"],
		    'amount' 			=> $_POST["amount"],
		    'max_val' 			=> $_POST["max_val"],
		    'min_val' 			=> $_POST["min_val"],
		    'total_limit_use' 	=> $_POST["total_limit_use"],
		    'limit_use_per_user'=> $_POST["limit_use_per_user"],
		    'new_cust_only' 	=> $_POST["new_cust_only"],
		    'active_status' 	=> $_POST["active_status"],
		    'start' 			=> $_POST["start"],
		    'end_time' 			=> $_POST["end_time"]
		);
		 
		//Encode the array into JSON.
		$jsonDataEncoded = json_encode($jsonData);
		 
		//Tell cURL that we want to send a POST request.
		curl_setopt($ch, CURLOPT_POST, 1);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		 
		//Attach our encoded JSON string to the POST fields.
		curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonDataEncoded);
		 
		//Set the content type to application/json
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json', 'Authorization: '.$token)); 
		 
		//Execute the request
		$result = curl_exec($ch);

		/* Check for 404 (file not found). */
	    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
	    // Check the HTTP Status code
	    switch ($httpCode) {
	        case 200:
	            $error_status = "200: Success";
	            header("Location: get_all_deals.php?token=".$token); 
	            break;
	        case 404:
	            $error_status = "404: API Not found";
	            break;
	        case 500:
	            $error_status = "500: servers replied with an error.";
	            break;
	        case 502:
	            $error_status = "502: servers may be down or being upgraded. Hopefully they'll be OK soon!";
	            break;
	        case 503:
	            $error_status = "503: service unavailable. Hopefully they'll be OK soon!";
	            break;
	        default:
	            $error_status = "Undocumented error: " . $httpCode . " : " . curl_error($ch);
	            break;
	    }
	}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Add Deals</title>
	<!-- <style type="text/css">
		.deals-form {
			margin-left: 35%;
		}
		.submit {
			margin-top: 5%;
			margin-left: 38%;
		}
	</style> -->
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="assets/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="assets/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <header class="main-header">
            <a href="#" class="logo" data-toggle="push-menu" role="button" style="text-decoration: none">
              <span class="logo-mini"><img src=""></span>
              <span class="logo-lg"><b>Deals </b>Service</span>
              <span class="sr-only">Toggle navigation</span>
            </a>
        </header>
        <aside class="main-sidebar">    
            <section class="sidebar">        
              <div class="user-panel">
                <div class="pull-left image">
                  <img src="assets/dist/img/admin.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                  <p>User</p>
                  <a><i class="fa fa-circle text-success"></i> Online</a>
                </div>
             </div>
             <ul class="sidebar-menu" data-widget="tree">
              <li><?php echo '<a href="get_all_deals.php?r_id='.$r_id.'&token='.$token.'" style="text-decoration: none"><i class="fa fa-circle-o"></i> All</a>' ?></li>
              <li><?php echo '<a href="get_all_active_deals.php?r_id='.$r_id.'&token='.$token.'" style="text-decoration: none"><i class="fa fa-circle-o"></i> Active</a>' ?></li>
              <li><?php echo '<a href="get_all_expired_deals.php?r_id='.$r_id.'&token='.$token.'" style="text-decoration: none"><i class="fa fa-circle-o"></i> Expired</a>' ?></li>
              <li><?php echo '<a href="form_add_deals.php?r_id='.$r_id.'&token='.$token.'" style="text-decoration: none"><i class="fa fa-book"></i> Add Deals</a>' ?></li>
              <li><?php echo '<a href="restaurant_history.php?token='.$token.'" style="text-decoration: none"><i class="fa fa-book"></i>Deals History</a>' ?></li>
              <li>
                <?php echo '<a href="logout.php?token='.$token.'" style="text-decoration: none">
                  <i class="fa fa-sign-out"></i> <span>Logout</span>
                </a>'?>
              </li>
             </ul>
           </section>
           <!-- /.sidebar -->
        </aside>

        <div class="content-wrapper">
            <section class="content-header">
                <h1>
                    Add Deals
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.php"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Add Deals</li>
                </ol>
            </section>           
            <section class="content">
            	<div class="box box-primary">
            		<form action="" method="post" enctype="multipart/form-data" role="form">
            			<div class="box-body">
            				<div class="form-group">
            					<label>Kode Voucher</label>
            					<input type="text" class="form-control" name=code placeholder="Masukkan kode voucher" required>
            				</div>
            				<div class="form-group">
            					<label>Nama Voucher</label>
            					<input type="text" class="form-control" name=name placeholder="Masukkan nama voucher" required>
            				</div>
            				<div class="form-group">
            					<label>Deskripsi</label>
            					<input type="text" class="form-control" name=description placeholder="Masukkan deskripsi" required>
            				</div>
            				<div class="form-group">
            					<label>Tipe Voucher</label>
            					<br>
            					<select class="form-control" name="type" required>
            						<option value="0">Presentase</option>
            						<option value="1">Potongan langsung</option>
            					</select>
                          	</div>
            				<div class="form-group">
            					<label>Besar Diskon</label>
            					<input type="text" class="form-control" name=amount placeholder="Masukkan besar diskon" required>
            				</div>
            				<div class="form-group">
            					<label>Max Diskon</label>
            					<input type="text" class="form-control" name=max_val placeholder="Masukkan maksimal diskon" required>
            				</div>
            				<div class="form-group">
            					<label>Min Belanja</label>
            					<input type="text" class="form-control" name=min_val placeholder="Masukkan minimal belanja" required>
            				</div>
            				<div class="form-group">
            					<label>Banyak Voucher</label>
            					<input type="text" class="form-control" name=total_limit_use placeholder="Masukkan banyak voucher" required>
            				</div>
            				<div class="form-group">
            					<label>Batas penggunaan tiap customer</label>
            					<input type="text" class="form-control" name=limit_use_per_user placeholder="Masukkan batas penggunaan tiap customer" required>
            				</div>
            				<div class="form-group">
            					<label>Hanya Customer baru</label><br>
            					<input type="radio" name="new_cust_only" value="true" required> Ya
            					<br>
            					<input type="radio" name="new_cust_only" value="false" required> Tidak
            				</div>
            				<div class="form-group">
            					<label>Status Voucher</label><br>
            					<input type="radio" name="active_status" value="true" required> Aktifkan
            					<br>
            					<input type="radio" name="active_status" value="false" required> Nanti Dulu
            				</div>
							<div class="form-group">
            					<label>Berlaku sejak</label>
            					<input type="text" class="form-control" name=start placeholder="Masukkan waktu mulai berlaku" required>
            				</div>
            				<div class="form-group">
            					<label>Berakhir pada</label>
            					<input type="text" class="form-control" name=end_time placeholder="Masukkan waktu berakhir" required>
            				</div>
            			</div>
            			<div class="box-footer">
            				<button type="submit" name="submit" value="submit" class="btn btn-primary">Submit</button>
            				<button type="reset" class="btn btn-md btn-danger">Reset</button>
            			</div>
            		</form>
            	</div>
            </section>
        </div>
    </div>

    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

    <script>
        $(function () {
            $('#example1').DataTable()
            $('#example2').DataTable({
                'paging': true,
                'lengthChange': false,
                'searching': false,
                'ordering': true,
                'info': true,
                'autoWidth': false
            })
        })
    </script>
	
</body>
</html>