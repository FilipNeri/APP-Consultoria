package com.nerifilipe.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerifilipe.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

//cria a vizualização do fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //entra dentro do About uma activity, se fosse no main era só colocar this
        String descricao = "A ATM Consultoria tem como missão apoiar organizações"+
                " que desejam alcançar o sucesso através da excelência em gestão"+
                " e da busca por quelidade.";
        Element versao = new Element();

        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                    .addEmail("atendimento@atm.com.br", "Envie um email")
                    .addWebsite("https://www.google.com/","Acesse nosso site")

                .addGroup("Redes Sociais")
                    .addFacebook("filipe.neri.39","Facebook")
                    .addInstagram("filipNeri","Instagram")
                    .addTwitter("FilipeNeri5","Twitter")
                    .addYoutube("FilipeNeri","Youtube")
                    .addGitHub("FilipNeri","GitHub")
                    .addPlayStore("com.instagram.android","Download App")
                .addItem(versao)

                .create();

        return view;
//        return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}
