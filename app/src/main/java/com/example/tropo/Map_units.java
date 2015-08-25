package com.example.tropo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Map_units extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnMarkerClickListener {

    private static final LatLng PENTADBIRAN = new LatLng(3.811914, 100.818351);
    private static final LatLng LIBRARY = new LatLng(3.812327, 100.818501);
    private static final LatLng AVA = new LatLng(3.812557, 100.818383);
    private static final LatLng DEWAN_SUKAN = new LatLng(3.810246, 100.816507);
    private static final LatLng KAFE_ASRAMA = new LatLng(3.811622, 100.813057);
    private static final LatLng UPS = new LatLng(3.813143, 100.815383);

    private static final LatLng JTMK_JMSK_JPA_JP = new LatLng(3.812557, 100.817679);
    private static final LatLng JKA_JKE = new LatLng(3.812542, 100.816195);
    private static final LatLng JPH = new LatLng(3.811726, 100.816184);
    private static final LatLng JHEP = new LatLng(3.811721, 100.817302);

    public static final String TAG = Map_general.class.getSimpleName();
    Polyline polylineDewan, polylineLibrary, polyline, polyFinal;
    AlertDialog.Builder alertDialog;
    LatLng latLng2 = new LatLng(3.811564, 100.815859);
    /*
     * Define a request code to send to Google Play services
     * This code is returned in Activity.onActivityResult
     *
     */

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private ImageView imageView;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_maps);

        // // Check if has GPS
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }

        //Map_general.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setUpMapIfNeeded();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(0); // No delay.
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        //utk dptkn coordinate jer
        // Setting a click event handler for the map


    }


    @Override //Handle orientation of map
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {

                setUpMap();

            }
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void setUpMap() {

        // mMap.addMarker(new MarkerOptions().position(new LatLng(3.812507, 100.817666)).title("Block A").icon(BitmapDescriptorFactory.fromResource(R.drawable.ico_tropo)));

        mMap.addMarker(new MarkerOptions().position(JTMK_JMSK_JPA_JP).title("UTM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(JKA_JKE).title("COT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(JPH).title("ULPL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(JHEP).title("JHEP").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(UPS).title("UPS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(LIBRARY).title("Library").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(AVA).title("Unit Multimedia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(PENTADBIRAN).title("Bangunan Pentadbiran").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(KAFE_ASRAMA).title("Unit Asrama/MA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.addMarker(new MarkerOptions().position(DEWAN_SUKAN).title("Unit Sukan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(3.811564, 100.815859)).title("Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(3.812039, 100.811649)).title("Legend").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_legend)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(3.811239, 100.811649)).title("Select your destination").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_destination)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(3.810439, 100.811649)).title("Clear Line").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_clear)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(3.809639, 100.811649)).title("Back").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_back)));

        mMap.getUiSettings().setAllGesturesEnabled(false); //disable all gesture
        mMap.getUiSettings().setZoomControlsEnabled(false); //disable zoom button
        mMap.getUiSettings().setMyLocationButtonEnabled(false); //enable locate button

        //ni utk background dye
        /*
        GroundOverlayOptions bg = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.map_bg))
                .position(new LatLng( 3.811564, 100.815859), 1500f, 900f);
        mMap.addGroundOverlay(bg);
        */

        //ni utk map psis tu
        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.main_map))
                .position(new LatLng(3.811564, 100.815859), 850f, 550f);
        mMap.addGroundOverlay(newarkMap);
    }

    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());
        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();

        final LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        //mMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude, currentLongitude)).title("Current Location"));
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("You are here!");
        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.5f)); //zoom

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            boolean doNotMoveCameraToCenterMarker = true;

            public boolean onMarkerClick(Marker arg0) {

                Marker marker;
                if (arg0.getTitle().equals("Legend")) {
                    Dialog settingsDialog = new Dialog(Map_units.this);
                    settingsDialog.getWindow().requestFeature(Window.FEATURE_SWIPE_TO_DISMISS);
                    settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                    settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.legend_layout, null));
                    settingsDialog.show();

                } else if (arg0.getTitle().equals("Select your destination")) {
                    alertDialog = new AlertDialog.Builder(Map_units.this);
                    String names[] ={"Unit Perpustakaan", "Unit Perhubungan & Latihan Industri (UPLI)", "Unit Peperiksaan", "Unit Sukan & Kokurikulum", "Unit Asrama",
                    "Unit Teknologi Maklumat (UTM)", "Unit Pembangunan Instruksional & Multimedia", "Unit Pembangunan & Senggaraan (UPS)", "Unit Pentadbiran", "Unit Kewangan",
                    "Unit Jaminan Kualiti", "Unit CISEC", "Unit Penyelidikan & Inovasi", "Unit Perhubungan Awam", "Unit Latihan & Pendidikan Lanjutan (ULPL)",
                    "Unit Keusahawanan", "Clinic (MA)", "Centre of Technology (COT)"};
                    LayoutInflater inflater = getLayoutInflater();
                    View convertView = (View) inflater.inflate(R.layout.map_general_listview, null);
                    alertDialog.setView(convertView);
                    alertDialog.setTitle("Where you want to go?");
                    ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Map_units.this, android.R.layout.simple_list_item_1, names);
                    lv.setAdapter(adapter);
                    alertDialog.show();

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            // When clicked, show a toast with the TextView text
                            if (position == 0)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, LIBRARY).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 1)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 2)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 3)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, DEWAN_SUKAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 4)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, KAFE_ASRAMA).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 5)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, JTMK_JMSK_JPA_JP).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 6)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, AVA).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 7)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, UPS).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 8)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 9)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 10)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 11)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 12)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 13)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, PENTADBIRAN).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 14)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, JPH).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 15)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, JHEP).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 16)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, KAFE_ASRAMA).width(6).color(Color.BLUE).geodesic(true));
                            }
                            else if (position == 17)
                            {
                                polyline = mMap.addPolyline((new PolylineOptions()).add(latLng, JKA_JKE).width(6).color(Color.BLUE).geodesic(true));
                            }

                        }
                    });

                } else if (arg0.getTitle().equals("Clear Line")) {
                    buang();
                } else if (arg0.getTitle().equals("Back")) {
                    finish();

                } else if (arg0.getTitle().equals("UTM")) {
                    Intent intent = new Intent(Map_units.this, Map_JTMK_JMSK.class);
                    startActivity(intent);
                }
                Toast.makeText(Map_units.this, arg0.getTitle(), Toast.LENGTH_SHORT).show();
                return doNotMoveCameraToCenterMarker;
            }
        });
    }

    public void buang()
    {
        polyline.remove();
    }


    @Override
    public void onConnected(Bundle bundle) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        } else {
            handleNewLocation(location);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
                /*
                 * Thrown if Google Play services canceled the original
                 * PendingIntent
                 */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        } else {
            /*
             * If no resolution is available, display a dialog to the
             * user with the error.
             */
            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }



}
