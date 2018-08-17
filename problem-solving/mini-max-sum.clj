(defn slice
  ([coll start] (subvec (vec coll) start))
  ([coll start end] (subvec (vec coll) start end)))

(defn minimum [coll n]
  (apply + (slice (sort coll) 0 n)))

(defn maximum [coll n]
  (let [last-i (count coll)]
    (apply + (slice (sort coll) (- last-i n)))))

(defn miniMaxSum [coll]
  (print (str (minimum coll 4) " " (maximum coll 4))))
