(defn get-line-from-file [number]
  (with-open [wordlist (clojure.java.io/reader "wordlist.txt")] 
    (doseq [line (line-seq wordlist)] 
      (if (re-seq (re-pattern number) line) 
        (println line)
      )
    )
  )
)
