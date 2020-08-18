package AssetContainer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

public class AssetCreator {

	public static final String ASSET_CONTAINER = "ASSET_CONTAINER";
	public static final String ASSET_CONTAINER_COMPRESSED = "ASSET_CONTAINER_COMPRESSED";

	public void criar(String eArquivo, String eLocal) {
	
		criarGeral(eArquivo,eLocal,ASSET_CONTAINER);

	}

	
	public void criarCompressed(String eArquivo, String eLocal) {

		criarGeral(eArquivo,eLocal,ASSET_CONTAINER_COMPRESSED);
		
	}

	
	
	private void criarGeral(String eArquivo, String eLocal,String eCabecalho) {
		
		try {

			RandomAccessFile raf = new RandomAccessFile(new File(eArquivo), "rw");

			FileUtils fu = new FileUtils(raf);

			fu.limpar();

			fu.inicio();

			fu.writeString(eCabecalho);

			if (eCabecalho.contentEquals(ASSET_CONTAINER)) {
				
				criarPasta(fu, eLocal);

			} else 	if (eCabecalho.contentEquals(ASSET_CONTAINER_COMPRESSED)) {
				criarPastaCompressed(fu, eLocal);
	
			}
			

			//fu.dump();

			raf.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	
	
	public void criarPasta(FileUtils fu, String eLocal) {


		File dir = new File(eLocal);

		ArrayList<Ponto> mPontos = new ArrayList<Ponto>();

		if (dir.exists()) {
			for (File eDir : dir.listFiles()) {

				if (eDir.isDirectory()) {

					fu.writeLong(11);
					fu.writeString(eDir.getName());

					long eInicio = fu.getPonteiro();

					fu.writeLong(0);

					long eFim = fu.getPonteiro();

					fu.writeLong(0);

					mPontos.add(new Ponto(eDir.getAbsolutePath(), 11, eInicio, eFim));

				} else if (eDir.isFile()) {

					fu.writeLong(12);
					fu.writeString(eDir.getName());

					long eInicio = fu.getPonteiro();

					fu.writeLong(0);

					long eFim = fu.getPonteiro();

					fu.writeLong(0);

					mPontos.add(new Ponto(eDir.getAbsolutePath(), 12, eInicio, eFim));

				}

				// System.out.println(" ->> " + eDir.getName() + " :: "+ eDir.isDirectory());
			}
		}

		fu.writeLong(13);

		//System.out.println(" ALOCANDO : " + eLocal);

		long ePonteiroLocal = fu.getPonteiro();

		for (Ponto PontoC : mPontos) {

			//System.out.println("\t -->> " + PontoC.getTipo() + " : " + PontoC.getNome().replace(eLocal+"\\", ""));

			fu.setPonteiro(ePonteiroLocal);

			if (PontoC.getTipo() == 11) {

				long ePastaPonteiro_Inicio = fu.getPonteiro();

				criarPasta(fu, PontoC.getNome());

				long ePastaPonteiro_Fim = fu.getPonteiro();

				ePonteiroLocal = fu.getPonteiro();

				fu.setPonteiro(PontoC.getInicio());
				fu.writeLong(ePastaPonteiro_Inicio);

				fu.setPonteiro(PontoC.getFim());
				fu.writeLong(ePastaPonteiro_Fim);

			} else if (PontoC.getTipo() == 12) {

				long eAquivoPonteiro_Inicio = fu.getPonteiro();
				
				
				try {

					RandomAccessFile mArquivando = new RandomAccessFile(new File(PontoC.getNome()), "r");

					long mAquivandoIndex = 0;
					long mAquivandoTamanho = mArquivando.length();
					
					mArquivando.seek(0);
				
					while(mAquivandoIndex<mAquivandoTamanho) {
						
						fu.writeByte(mArquivando.readByte());
						
						mAquivandoIndex+=1;
					}
					
					mArquivando.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
				
				
				long eAquivoPonteiro_Fim = fu.getPonteiro();

				ePonteiroLocal = fu.getPonteiro();

				fu.setPonteiro(PontoC.getInicio());
				fu.writeLong(eAquivoPonteiro_Inicio);

				fu.setPonteiro(PontoC.getFim());
				fu.writeLong(eAquivoPonteiro_Fim);

			}

			fu.setPonteiro(ePonteiroLocal);

		}

	}


	public void criarPastaCompressed(FileUtils fu, String eLocal) {


		File dir = new File(eLocal);

		ArrayList<Ponto> mPontos = new ArrayList<Ponto>();

		if (dir.exists()) {
			for (File eDir : dir.listFiles()) {

				if (eDir.isDirectory()) {

					fu.writeLong(11);
					fu.writeString(eDir.getName());

					long eInicio = fu.getPonteiro();

					fu.writeLong(0);

					long eFim = fu.getPonteiro();

					fu.writeLong(0);

					mPontos.add(new Ponto(eDir.getAbsolutePath(), 11, eInicio, eFim));

				} else if (eDir.isFile()) {

					fu.writeLong(12);
					fu.writeString(eDir.getName());

					long eInicio = fu.getPonteiro();

					fu.writeLong(0);

					long eFim = fu.getPonteiro();

					fu.writeLong(0);

					mPontos.add(new Ponto(eDir.getAbsolutePath(), 12, eInicio, eFim));

				}

				// System.out.println(" ->> " + eDir.getName() + " :: "+ eDir.isDirectory());
			}
		}

		fu.writeLong(13);

		//System.out.println(" ALOCANDO : " + eLocal);

		long ePonteiroLocal = fu.getPonteiro();

		for (Ponto PontoC : mPontos) {

			System.out.println("\t -->> " + PontoC.getTipo() + " : " + PontoC.getNome().replace(eLocal+"\\", ""));

			fu.setPonteiro(ePonteiroLocal);

			if (PontoC.getTipo() == 11) {

				long ePastaPonteiro_Inicio = fu.getPonteiro();

				criarPastaCompressed(fu, PontoC.getNome());

				long ePastaPonteiro_Fim = fu.getPonteiro();

				ePonteiroLocal = fu.getPonteiro();

				fu.setPonteiro(PontoC.getInicio());
				fu.writeLong(ePastaPonteiro_Inicio);

				fu.setPonteiro(PontoC.getFim());
				fu.writeLong(ePastaPonteiro_Fim);

			} else if (PontoC.getTipo() == 12) {

				long eAquivoPonteiro_Inicio = fu.getPonteiro();
				
				
				try {

					RandomAccessFile mArquivando = new RandomAccessFile(new File(PontoC.getNome()), "r");

					int mAquivandoIndex = 0;
					int mAquivandoTamanho = (int)mArquivando.length();
					
					mArquivando.seek(0);
				
					byte[] mTemporario = new byte[(int)mAquivandoTamanho];
					
					while(mAquivandoIndex<mAquivandoTamanho) {
						
						mTemporario[mAquivandoIndex] = (mArquivando.readByte());
						
						mAquivandoIndex+=1;
					}
					
					 try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
					      try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
					        gzipOutputStream.write(mTemporario);
					      }
					      
					      byte[] mTemporario2=  byteArrayOutputStream.toByteArray();
					      
					      mAquivandoIndex=0;
							mAquivandoTamanho=mTemporario2.length;
							while(mAquivandoIndex<mAquivandoTamanho) {
								
								fu.writeByte(mTemporario2[mAquivandoIndex]);
								mAquivandoIndex+=1;
							}
							
							
					    } catch(IOException e) {
					      throw new RuntimeException("Failed to zip content", e);
					    }
					
					 
					
					mArquivando.close();
					
					
					
					
				} catch (IOException e) {

					e.printStackTrace();
				}
				
				
				long eAquivoPonteiro_Fim = fu.getPonteiro();

				ePonteiroLocal = fu.getPonteiro();

				fu.setPonteiro(PontoC.getInicio());
				fu.writeLong(eAquivoPonteiro_Inicio);

				fu.setPonteiro(PontoC.getFim());
				fu.writeLong(eAquivoPonteiro_Fim);

			}

			fu.setPonteiro(ePonteiroLocal);

		}

	}

	
}
