(defn slice
  ([coll start] (drop start coll))
  ([coll start end]
   (let [len (count coll)
         pos-index #(if (neg? %)
                      (max (- len %) 0)
                      %)
         start (pos-index start)
         end (pos-index end)]
     (->> coll (drop start) (take (- end start))))))

(slice [86 86] 0 2)
(defn minimum [coll n]
  (apply + (slice (sort coll) 0 n)))

(defn maximum [coll n]
  (apply + (slice (sort coll) (- n))))

(defn miniMaxSum [coll n]
  (str (minimum coll n) " " (maximum coll n)))

;; Testing cases

(defn nums [n]
  (take n (repeatedly #(rand-int 100))))

(def arr (nums 2))
(list* arr)

(print (miniMaxSum arr 2))
