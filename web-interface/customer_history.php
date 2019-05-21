<?php

    $token = $_GET["token"];

    //Authentication as customer
    $url = 'deals-service-spring.herokuapp.com/history/user';

	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => $url,
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "GET",
  		CURLOPT_HTTPHEADER => array(
    		'Authorization: '.$token
  		),
	));

	$response = curl_exec($curl);

	/* Check for 404 (file not found). */
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    // Check the HTTP Status code
    if (checkstatus($httpCode) == TRUE) {
        $allHistory = json_decode($response, true); 
    }
	curl_close($curl);

    function checkstatus($code) {
        switch ($code) {
            case 200:
                $error_status = "200: Success";
                return TRUE;
            case 404:
                $error_status = "404: API Not found";
                return $error_status;
            case 500:
                $error_status = "500: servers replied with an error.";
                return $error_status;
            case 502:
                $error_status = "502: servers may be down or being upgraded. Hopefully they'll be OK soon!";
                return $error_status;
            case 503:
                $error_status = "503: service unavailable. Hopefully they'll be OK soon!";
                return $error_status;
            default:
                $error_status = "Undocumented error: " . $code;
                return $error_status;
        }
    }
?>

<!DOCTYPE html>
<html>
<head>
    <title>Get All Deals of A Customer</title>

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
              <li><?php echo '<a href="customer_history.php?token='.$token.'" style="text-decoration: none"><i class="fa fa-book"></i>Deals History</a>' ?></li>
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
                    Deals History of A Customer
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.php"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">History Deals of A Customer</li>
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
                                            <th>Restaurant ID</th>
                                            <th>Voucher ID</th>
                                            <th>Timestamp</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php
                                            if($allHistory != null)
                                            for ($i=0; $i < sizeof($allHistory); $i++) {
                                        ?>
                                        <tr>
                                            <td><?php echo $allHistory[$i]['dh_id'] ?></td>
                                            <td><?php echo $allHistory[$i]['r_id'] ?></td>
                                            <td><?php echo $allHistory[$i]['id'] ?></td>
                                            <td><?php echo $allHistory[$i]['create_at'] ?></td>
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