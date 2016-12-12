import java.io._
import java.util.zip._
import org.apache.commons.io.IOUtils

case class ArchiveEntry(name: String, data: Array[Byte])

object Compression {
  def zip(entries: Array[ArchiveEntry]): Array[Byte] = {
    val memStream = new ByteArrayOutputStream
    val zip = new ZipOutputStream(memStream)
    entries.foreach (e => {
      zip.putNextEntry(new ZipEntry(e.name))
      zip.write(e.data)
      zip.closeEntry()
    })
    zip.close()
    memStream.toByteArray
  }

  def unzip(content: Array[Byte]): Array[ArchiveEntry] = {
    val zip = new ZipInputStream(new ByteArrayInputStream(content))
    Stream
      .continually(zip.getNextEntry)
      .takeWhile(s => s != null)
      .map(s => ArchiveEntry(s.getName, IOUtils.toByteArray(zip)))
      .toArray
  }
}
