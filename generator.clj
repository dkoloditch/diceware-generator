(defn get-line-from-file [number]
  (with-open [wordlist (clojure.java.io/reader "wordlist.txt")] 
    (doall
      (for [line (line-seq wordlist) :when (re-seq (re-pattern number) line)]
        (apply str line)
      )
    )
  )
)
