package AssetContainer;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class ArquivoTexto {

	private Arquivo mArquivo;
	
	private boolean mObtido;
	private String mConteudo;

	private boolean mParseado;
	private ArrayList<String> mLinhas;
	
	private boolean mContado;
	private int mTamanho;
	
	public ArquivoTexto(Arquivo eArquivo) {
		mArquivo=eArquivo;
		
		mObtido=false;
		mConteudo=null;
		
		mContado=false;
		mTamanho-=1;
		
		mParseado=false;
		mLinhas= new ArrayList<String>();
	}
	
	public String getConteudo() {	
		
		if (!mObtido) {
			mConteudo=new String(mArquivo.getBytes(), Charset.forName("UTF-8"));
			mObtido=true;
		}
		
		return mConteudo;
	}
	
	public int getTamanho() {
		
		if(!mContado) {
			mTamanho=getConteudo().length();
			mContado=true;
		}
		
		return mTamanho;
	}
	
	public  ArrayList<String> getLinhas(){
		if (!mParseado) {
			
			
			int mIndex=0;
			int mFim = getConteudo().length();
			
			String eLinha = "";
			
			while(mIndex<mFim) {
				String e = String.valueOf (mConteudo.charAt(mIndex));
				if (e.contentEquals("\n")) {
					mLinhas.add(eLinha);
					eLinha="";
				}else {
					eLinha+=e;
				}
				mIndex+=1;
			}
			
			if (eLinha.length()>0) {
				mLinhas.add(eLinha);
			}
			
			mParseado=true;
		}
		
		return mLinhas;
	}
	
}
