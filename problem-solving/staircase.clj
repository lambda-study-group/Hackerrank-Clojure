(defn *str [tok n]
  ((fn [string n] (if (pos? n)
                      (recur (str string tok) (dec n))
                      string))
   ""
   n))

(defn staircase [n]
  (clojure.string/join
    "\n"
    (map
      #(str (*str " " (- n %)) (*str "#" %))
      (range 1 (inc n)))))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(print (staircase n))
