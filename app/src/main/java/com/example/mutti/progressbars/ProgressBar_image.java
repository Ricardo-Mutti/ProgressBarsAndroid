package com.example.mutti.progressbars;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class ProgressBar_image extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress_bar_image, container, false);

        Button btn_progress_image = (Button) view.findViewById(R.id.btn_progress_image);

       final  ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar_custom1);
        final  ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progressBar_custom2);

        btn_progress_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int totalProgressTime = 100;

                final Thread t = new Thread() {//Abre uam thread pra continuar a execucao qnd o evento de precionar o botao acabar
                    @Override
                    public void run() {
                        int jumpTime = 0;

                        while (jumpTime < totalProgressTime) {//Enquanto não chegou no 100%
                            try {
                                sleep(200);//Espera 200ms
                                jumpTime += 5;//Salta de 5 em 5 até 100
                                final String jt = String.valueOf(jumpTime) + "/100";

                                progressBar.setProgress(100-jumpTime);//Muda o progresso
                                progressBar2.setProgress(100-jumpTime);//Muda o progresso

                                //progressBar.setSecondaryProgress(jumpTime + 10);//Progresso secundario
                               // progressBar2.setSecondaryProgress(jumpTime + 10);//Progresso secundario de maia 10 na frente


                                getActivity().runOnUiThread(new Runnable() {//Tudo que muda a UI tem que rodar numa thread diferente
                                    @Override
                                    public void run() {
//                                        percent1.setText(jt);
//                                        percent2.setText(jt);
                                    }
                                });


                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();//Começa a thread

                Toast.makeText(getActivity(),
                        "Button is clicked!", Toast.LENGTH_LONG).show();
            }
        });
        return view;




    }


}
