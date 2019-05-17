<section class="body">

	<div class="inner-wrapper">
		<!-- start: sidebar -->
		<aside id="sidebar-left" class="sidebar-left">
		
			<div class="sidebar-header">
				<div class="sidebar-title">
					Navigation
				</div>
				<div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html" data-fire-event="sidebar-left-toggle">
					<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
				</div>
			</div>
		
			<div class="nano">
				<div class="nano-content">
					<nav id="menu" class="nav-main" role="navigation">
						<ul class="nav nav-main">

							<li>
								<a href="#">
									<i class="fa fa-home" aria-hidden="true"></i>
									<span>Dashboard</span>
								</a>
							</li>

							<li>
								<a href="#">
									<i class="fa fa-cogs" aria-hidden="true"></i>
									<span>Manage Deals</span>
								</a>
							</li>

							@yield('left-sidebar')
						</ul>
					</nav>
				</div>				
			</div>
		
		</aside>
		<!-- end: sidebar -->


		<section role="main" class="content-body">			

			<header class="page-header">
				<h2>@yield('title-page')</h2>
			</header>

			<!-- start: page -->
			@yield('content')
			<!-- end: page -->
		</section>
	</div>	
</section>