import {useEffect, useState} from "react";
// Backend URL API
const API = "http://localhost:8080/api/assets";

export default function App() {
    // what is queried
    const [q, setQ] = useState("");
    // page of results
    const [page, setPage] = useState(0);
    // The assets received
    const [data, setData] = useState({content: [], totalPages: 0, totalElements: 0});

    // Ask the server for data.
    const load = async (p = 0) => {
        const url = q.trim()
            ? `${API}/search?q=${encodeURIComponent(q.trim())}&page=${p}`
            : `${API}?page=${p}`;
        const res = await fetch(url);
        const json = await res.json();
        setData(json);
        setPage(p);
    };

    useEffect(() => {
        load(0);
    }, []);

    return (
        <div style={{maxWidth: 840, margin: "2rem auto", fontFamily: "system-ui"}}>
            <h1>EquipReserve Search Function</h1>

            <div style={{display: "flex", gap: 8, marginBottom: 12}}>
                <input
                    value={q}
                    onChange={(e) => setQ(e.target.value)}
                    placeholder="Search name/model/serial…"
                    style={{flex: 1, padding: 8}}
                />
                <button onClick={() => load(0)} style={{padding: "8px 14px"}}>Search</button>
            </div>

            <div style={{fontSize: 14, marginBottom: 8}}>
                Results: {data.totalElements ?? 0}
            </div>

            <table width="100%" cellPadding="8" style={{borderCollapse: "collapse"}}>
                <thead>
                <tr style={{textAlign: "left", borderBottom: "1px solid #ddd"}}>
                    <th>Name</th>
                    <th>Model</th>
                    <th>Serial</th>
                </tr>
                </thead>
                <tbody>
                {(data.content ?? []).map(a => (
                    <tr key={a.id} style={{borderBottom: "1px solid #f0f0f0"}}>
                        <td>{a.name}</td>
                        <td>{a.model}</td>
                        <td>{a.serial}</td>
                    </tr>
                ))}
                {(data.content ?? []).length === 0 && (
                    <tr>
                        <td colSpan="3" style={{color: "#777"}}>No results</td>
                    </tr>
                )}
                </tbody>
            </table>

            <div style={{display: "flex", gap: 8, marginTop: 12, alignItems: "center"}}>
                <button onClick={() => load(Math.max(page - 1, 0))} disabled={page === 0}>Prev</button>
                <span>Page {page + 1} of {data.totalPages || 1}</span>
                <button
                    onClick={() => load(page + 1)}
                    disabled={!data.totalPages || page >= data.totalPages - 1}
                >
                    Next
                </button>
            </div>
        </div>
    );
}
