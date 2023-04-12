package egisubastian.data.karyawan;

import javax.sql.DataSource;

import egisubastian.data.karyawan.repository.KaryawanRepository;
import egisubastian.data.karyawan.repository.impl.KaryawanRepositoryImpl;
import egisubastian.data.karyawan.service.KaryawanService;
import egisubastian.data.karyawan.service.impl.KaryawanServiceImpl;
import egisubastian.data.karyawan.util.DatabaseUtil;
import egisubastian.data.karyawan.view.KaryawanView;

public class App 
{
    public static void main( String[] args )
    {
         // Datasource
         DataSource dataSource = DatabaseUtil.getDataSource();

         // Set Datasource
         KaryawanRepository karyawanRepository = new KaryawanRepositoryImpl(dataSource);
        
         KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepository);
 
         // View
         KaryawanView karyawanView = new KaryawanView(karyawanService);
 
         // Show Menu
         karyawanView.loginMenu();
    }
}
