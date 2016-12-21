ScalaZip example

Simple example of zip library usage in scala

Installation

TODO: Describe the installation process

Usage
```scala
        val entries = new Array[ArchiveEntry](2)
        entries(0) = ArchiveEntry("FirstEntry", "FirstEntryData".getBytes())
        entries(1) = ArchiveEntry("SecondEntry", "SecondEntryData".getBytes)

        val compressed = Compression.zip(entries)
        val uncompressed = Compression.unzip(compressed)

        assert(uncompressed.length == entries.length)
        uncompressed.zipWithIndex.foreach(i => {
            assert(i._1.name  == entries(i._2).name)
            assert(i._1.data.mkString  == entries(i._2).data.mkString)
        })
```

Contributing

Fork it!
Create your feature branch: git checkout -b my-new-feature
Commit your changes: git commit -am 'Add some feature'
Push to the branch: git push origin my-new-feature
Submit a pull request :D
History

TODO: Write history

Credits

TODO: Write credits

License

TODO: Write license