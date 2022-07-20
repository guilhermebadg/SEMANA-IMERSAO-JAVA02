import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoradeFigurinhas {

    public void cria( InputStream inputStream, String NomeArquivo) throws Exception {

        // leitura da imagem
        //  InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria c transparencia + novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original p nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 200, novaAltura - 100);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 180);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever a nova imagem
        ImageIO.write(novaImagem, "png", new File(NomeArquivo));
    }
}