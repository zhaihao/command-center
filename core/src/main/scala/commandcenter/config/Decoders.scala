package commandcenter.config

import java.awt.Font

import io.circe.Decoder

object Decoders {
  implicit val fontDecoder: Decoder[Font] =
    Decoder.instance { c =>
      for {
        name <- c.get[String]("name")
        size <- c.get[Int]("size")
      } yield new Font(name, Font.PLAIN, size) // TODO: Also support style
    }
}
