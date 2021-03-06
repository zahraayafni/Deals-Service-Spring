<?php

    $token = $_GET['token'];
	$r_id = $_GET['r_id'];
	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/".$r_id."/exp",
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "GET",
  		CURLOPT_HTTPHEADER => array(
    		"cache-control: no-cache"
  		),
	));

	$response = curl_exec($curl);

	/* Check for 404 (file not found). */
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    // Check the HTTP Status code
    switch ($httpCode) {
        case 200:
            $error_status = "200: Success";
            $allDeals = json_decode($response, true); 	
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
            $error_status = "Undocumented error: " . $httpCode . " : " . curl_error($curl);
            break;
    }

	curl_close($curl);
?>

<!DOCTYPE html>
<html>
<head>
	<title>Get All Expired Deals of A Restaurant</title>

	<!-- <style type="text/css">
		.head {
			padding-left: 5px;
			display: inline-flex;
			list-style: none;
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
                    Expired Deals of A Restaurant
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.php"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Expired Deals of A Restaurant</li>
                </ol>
            </section>           
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <div class="box-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                        	<th>ID</th>
											<th>Kode Voucher</th>
											<th>Name</th>
											<th>Description</th>
											<th>Besar Diskon</th>
											<th>Maksimum Diskon</th>
											<th>Belanja Minimal</th>
											<th>Mulai</th>
											<th>Hingga</th>
											<th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php
                                            if($allDeals != null)
											for ($i=0; $i < sizeof($allDeals); $i++) {
										?>
										<tr>
											<td><?php echo $allDeals[$i]['id'] ?></td>
											<td><?php echo $allDeals[$i]['code'] ?></td>
											<td><?php echo $allDeals[$i]['name'] ?></td>
											<td><?php echo $allDeals[$i]['description'] ?></td>
											<td><?php echo $allDeals[$i]['amount'] ?></td>
											<td><?php echo $allDeals[$i]['max_val'] ?></td>
											<td><?php echo $allDeals[$i]['min_val'] ?></td>
											<td><?php echo $allDeals[$i]['start'] ?></td>
											<td><?php echo $allDeals[$i]['end_time'] ?></td>
											<td>
												<?php echo '<a href="voucher_details.php?r_id='.$r_id.'&'.'id='.$allDeals[$i]['id'].'"><button type="button" class="btn btn-primary">Details</button></a>' ?>
                                               <?php echo '<a href="edit_voucher.php?r_id='.$r_id.'&'.'id='.$allDeals[$i]['id'].'&token='.$token.'"><button type="button" class="btn btn-warning">Edit</button></a>' ?>
                                               <?php echo '<a href="delete_voucher.php?r_id='.$r_id.'&'.'id='.$allDeals[$i]['id'].'&token='.$token.'"><button type="button" class="btn btn-danger">Delete</button></a>' ?>
											</td>
										</tr>
										<?php 			
											}
										?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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