package com.example.ringgo_example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ringgo_example.myapplication.interfaces.ApiInterface;
import com.example.ringgo_example.myapplication.models.VehiclesResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String VEHICLE_DETAILS = "com.example.ringgo_example.VEHICLE_DETAILS";
    public static VehiclesResponse sVehiclesResponse;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.getVehicles();
    }

    public void getVehicles() {
        ApiInterface api = retrofit.create(ApiInterface.class);
        Observable<VehiclesResponse> call = api.getVehicles();
        final Intent intent = new Intent(this, DisplayVehiclesActivity.class);

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VehiclesResponse>() {
                    @Override
                    public void onNext(VehiclesResponse vehicles) {
                        sVehiclesResponse = vehicles;
                        startActivity(intent);
                    }

                    @Override
                    public void onComplete() {
                        // Nothing to do here
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        // Nothing to do here
                    }

                    @Override
                    public void onError(Throwable e) {
                        // cast to retrofit.HttpException to get the response code
                        //if (e instanceof HttpException) {
                            /*HttpException response = (HttpException)e;
                            int code = response.code();*/

                            DialogFragment newFragment = new ConnectionErrorDialogFragment();
                            newFragment.show(getSupportFragmentManager(), "connection_error");
                            newFragment.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialogInterface) {
                                    //do whatever you want when dialog is dismissed
                                }
                            });
                        //}
                    }
                });

        api.getVehicles();
    }
}
