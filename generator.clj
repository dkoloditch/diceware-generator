(defn get-line-from-file [number]
  (with-open [wordlist (clojure.java.io/reader "wordlist.txt")] 
    (doall
      (for [line (line-seq wordlist) :when (re-seq (re-pattern number) line)]
        (apply str line)
      )
    )
  )
)

(defn get-match [n]
  (re-seq 
    #"\b()[a-z]+|\d{1,4}$|([0-9]{1,4}(th|rd|st))$|[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\;\:\?]{1,2}$" 
    (apply str (get-line-from-file n))
  )
)

(defn generate-random-number [] 
  (apply str (take 1 (repeatedly #(+ (rand-int 55556) 11111))))
)

(defn get-numbers [n] (for [i (range n)] (generate-random-number)))

