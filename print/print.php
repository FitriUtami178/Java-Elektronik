<?php 
error_reporting(0);

  include "config/koneksi.php";
  
?>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>LAPORAN BARANG MASUK</title>
  </head>
  <body>
  	<a href="javascript:window.print()" target="_blank"><img src="img/print.jpg" alt="print" class="img-thumbnail" height="20" width="40" style="margin-top:5px"></a>

  	<?php
        $tanggal = date('Y-m-d');
        echo $tanggal;
        ?>
  <div class="container">
  	<div class="row">
  		<div class="col-md-12"><h1 class="text-center text-primary">LAPORAN BARANG MASUK</h1></div>
  	</div>
    <form method="post">
      <table>
        <tr>
          <td>Dari Tanggal <input type="date" name="dari"></td>
          <td>   Sampai <input type="date" name="sampai"></td>
          <td><input type="submit" name="cek" value="CEK"></td>
        </tr>
      </table>
    </form>
  	<br>
  	<div class="row">
  		<div class="col-md-12">
        <table class="table">
		        <thead class="thead-dark">
		            <tr>
		                <th>Kategori Barang</th>
		                <th>Kode Barang</th>
		                <th>Nama Produk</th>
		                <th>Jumlah Barang</th>
		                <th>Harga Jual</th>
		            </tr>
		        </thead>

		        <tbody>
		        	<?php 
		        		$sql = "SELECT * FROM tbl_barang";
		        		$query = mysqli_query($con, $sql);
		        		while($r= mysqli_fetch_array($query)){
		        	?>
		            <tr>
		                <td><?php echo $r['kt_barang'] ?></td>
		                <td><?php echo $r['kd_barang'] ?></td>
		                <td><?php echo $r['nama_barang'] ?></td>
		                <td><?php echo $r['jumlah_barang'] ?></td>
		                <td><?php echo $r['harga_jual'] ?></td>
		            </tr>
		            <?php } ?>
                
                
		        </tbody>
		    </table>

  		</div>
  	</div>

  </div>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>